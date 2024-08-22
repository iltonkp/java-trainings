package io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in;

import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
