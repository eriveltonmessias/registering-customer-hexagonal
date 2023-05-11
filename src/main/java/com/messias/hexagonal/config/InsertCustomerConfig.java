package com.messias.hexagonal.config;

import com.messias.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.messias.hexagonal.adapters.out.InsertCustomerAdapter;
import com.messias.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.messias.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ){
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
