package io.github.iltonkp.udemy_hexagonal_architecture.adapters.out;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.repository.CustomerRepository;
import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.repository.mapper.CustomerEntityMapper;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.domain.Customer;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;


    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

}
