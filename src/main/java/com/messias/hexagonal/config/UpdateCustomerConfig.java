package com.messias.hexagonal.config;

import com.messias.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.messias.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.messias.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.messias.hexagonal.application.core.usecase.UpdateCustomerUseCase;
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
