package io.github.iltonkp.udemy_hexagonal_architecture.adapters.out;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.repository.CustomerRepository;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.DeleteCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;


    @Override
    public void delete(String id) {

        customerRepository.deleteById(id);

    }

}
