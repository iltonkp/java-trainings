package io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;

public record CustomerRequestDto(@NotBlank String name, @NotBlank String cpf, @NotBlank String zipCode) {
}
