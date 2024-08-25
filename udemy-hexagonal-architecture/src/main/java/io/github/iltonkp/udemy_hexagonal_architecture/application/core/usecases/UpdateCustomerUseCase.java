package io.github.iltonkp.udemy_hexagonal_architecture.application.core.usecases;

import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in.UpdateCustomerInputPort;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.FindAddressByZipCodOutputPort;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodOutputPort findAddressByZipCodOutputPort;
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipCodOutputPort findAddressByZipCodOutputPort,
            UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodOutputPort = findAddressByZipCodOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode){
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }
}
