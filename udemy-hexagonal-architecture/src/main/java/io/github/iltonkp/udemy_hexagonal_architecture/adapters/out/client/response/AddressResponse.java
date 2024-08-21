package io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.client.response;

import lombok.Data;

@Data
public class AddressResponse {

    private String street;
    private String city;
    private String state;

}
