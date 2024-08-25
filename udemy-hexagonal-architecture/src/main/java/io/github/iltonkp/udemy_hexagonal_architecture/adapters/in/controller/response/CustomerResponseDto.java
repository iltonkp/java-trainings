package io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.controller.response;

public record CustomerResponseDto(String name, String cpf, Boolean isValidCpf, AddressResponseDto address) {
}
