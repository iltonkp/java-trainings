package io.github.iltonkp.udemy_hexagonal_architecture.config;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.FindAddressByZipCodeAdapter;
import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.InsertCustomerAdapter;
import io.github.iltonkp.udemy_hexagonal_architecture.adapters.out.SendCpfForValidationAdapter;
import io.github.iltonkp.udemy_hexagonal_architecture.application.core.usecases.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter
    ) {

        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);

    }

}
