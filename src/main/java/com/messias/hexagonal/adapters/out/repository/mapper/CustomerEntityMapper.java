package com.messias.hexagonal.adapters.out.repository.mapper;

import com.messias.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.messias.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
