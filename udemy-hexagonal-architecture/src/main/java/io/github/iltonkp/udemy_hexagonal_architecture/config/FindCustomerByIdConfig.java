package io.github.iltonkp.udemy_hexagonal_architecture.config;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.FindCustomerByIdAdapter;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.usecases.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {

        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);

    }

}
