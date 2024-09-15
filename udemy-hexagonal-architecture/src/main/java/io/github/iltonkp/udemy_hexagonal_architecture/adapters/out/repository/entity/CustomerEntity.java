package io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class CustomerEntity {

    @Id
    private String id;
    private String name;
    private String cpf;
    private Boolean validCpf;
    private AddressEntity address;
}
