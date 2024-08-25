package io.github.iltonkp.udemy_hexagonal_architecture.config;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.DeleteCustomerByIdAdapter;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.usecases.DeleteCustomerByIdUseCase;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.usecases.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {

        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);

    }
}
