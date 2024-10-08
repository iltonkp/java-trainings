package io.github.iltonkp.udemy_hexagonal_architecture.application.core.usecases;

import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id) {

        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

    }
}
