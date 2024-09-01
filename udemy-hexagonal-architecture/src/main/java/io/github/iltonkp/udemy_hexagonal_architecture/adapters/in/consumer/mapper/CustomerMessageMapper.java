package io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.consumer.mapper;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.consumer.message.CustomerMessage;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);

}
