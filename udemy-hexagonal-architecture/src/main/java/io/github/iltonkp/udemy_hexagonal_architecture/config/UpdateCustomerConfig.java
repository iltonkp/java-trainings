package io.github.iltonkp.udemy_hexagonal_architecture.config;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.FindAddressByZipCodeAdapter;
import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.UpdateCustomerAdapter;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.usecases.FindCustomerByIdUseCase;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.usecases.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
           FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {

        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);

    }

}
