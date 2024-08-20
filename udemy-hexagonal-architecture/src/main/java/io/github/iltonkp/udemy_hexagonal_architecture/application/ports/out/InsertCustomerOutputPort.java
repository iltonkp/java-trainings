package io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out;

import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
