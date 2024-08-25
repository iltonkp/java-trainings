package io.github.iltonkp.udemy_hexagonal_architecture.application.core.usecases;

import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in.InsertCustomerInputPort;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.FindAddressByZipCodOutputPort;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.InsertCustomerOutputPort;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodOutputPort findAddressByZipCodOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodOutputPort findAddressByZipCodOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort
    ) {

        this.findAddressByZipCodOutputPort = findAddressByZipCodOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;

    }

    @Override
    public void insert(Customer customer, String zipCod) {

        var address = findAddressByZipCodOutputPort.find(zipCod);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());

    }
}
