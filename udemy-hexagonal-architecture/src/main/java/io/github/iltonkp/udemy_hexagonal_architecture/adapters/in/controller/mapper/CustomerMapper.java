package io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.controller.mapper;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.controller.request.CustomerRequestDto;
import io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.controller.response.CustomerResponseDto;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "validCpf", ignore = true)
    Customer toCustomer(CustomerRequestDto customerRequestDto);


    CustomerResponseDto toCustomerResponseDto(Customer customer);
}
