package io.github.iltonkp.udemy_hexagonal_architecture.adapters.out;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.client.FindAddressByZipCodeClient;
import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.client.mapper.AddressResponseMapper;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Address;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.FindAddressByZipCodOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodOutputPort {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;
    private final AddressResponseMapper addressResponseMapper;


    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
