package io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.repository.entity;

import lombok.Data;

@Data
public class AddressEntity {
    private String street;
    private String city;
    private String state;
}
