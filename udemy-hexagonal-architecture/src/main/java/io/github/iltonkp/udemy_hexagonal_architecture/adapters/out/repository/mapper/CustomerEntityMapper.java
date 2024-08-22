package io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.repository.mapper;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.repository.entity.CustomerEntity;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);
}
