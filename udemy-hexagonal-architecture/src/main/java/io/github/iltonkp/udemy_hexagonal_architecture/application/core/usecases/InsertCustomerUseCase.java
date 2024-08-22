package io.github.iltonkp.udemy_hexagonal_architecture.application.core.usecases;

import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in.InsertCustomerInputPort;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.FindAddressByZipCodOutputPort;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodOutputPort findAddressByZipCodOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodOutputPort findAddressByZipCodOutputPort, InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodOutputPort = findAddressByZipCodOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCod) {

        var address = findAddressByZipCodOutputPort.find(zipCod);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);

    }
}
