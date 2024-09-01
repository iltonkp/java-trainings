package io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.client;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${address.client.url}"
)
public interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable(name = "zipCode")  String zipCode);
}
