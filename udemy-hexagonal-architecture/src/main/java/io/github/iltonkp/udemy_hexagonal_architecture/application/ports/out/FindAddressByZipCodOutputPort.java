package io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out;

import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Address;

public interface FindAddressByZipCodOutputPort {

    Address find(String zipCode);
}
