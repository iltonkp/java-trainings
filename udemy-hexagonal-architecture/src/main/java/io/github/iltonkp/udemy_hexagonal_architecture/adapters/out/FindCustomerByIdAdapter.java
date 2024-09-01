package io.github.iltonkp.udemy_hexagonal_architecture.adapters.out;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.repository.CustomerRepository;
import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.repository.mapper.CustomerEntityMapper;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;


    @Override
    public Optional<Customer> find(String id) {
       var customerEntity = customerRepository.findById(id);
       return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
