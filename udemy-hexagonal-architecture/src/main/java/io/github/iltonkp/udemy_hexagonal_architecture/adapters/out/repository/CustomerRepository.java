package io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.repository;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
