package io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out;

import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
