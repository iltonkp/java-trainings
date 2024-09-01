package io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerMessage {

    private String id;
    private String name;
    private String cpf;
    private String zipCode;
    private Boolean isValidCpf;

}