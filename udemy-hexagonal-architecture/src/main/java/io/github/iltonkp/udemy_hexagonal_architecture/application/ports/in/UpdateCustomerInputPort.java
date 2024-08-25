package io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in;

import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
