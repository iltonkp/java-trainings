package io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in;

import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}
