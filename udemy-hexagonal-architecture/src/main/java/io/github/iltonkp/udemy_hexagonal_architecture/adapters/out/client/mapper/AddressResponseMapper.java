package io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.client.mapper;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.client.response.AddressResponse;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress (AddressResponse addressResponse);
}
