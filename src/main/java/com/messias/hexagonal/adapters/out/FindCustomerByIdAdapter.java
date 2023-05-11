package com.messias.hexagonal.adapters.out;

import com.messias.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.messias.hexagonal.adapters.out.repository.CustomerRepository;
import com.messias.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.messias.hexagonal.application.core.domain.Customer;
import com.messias.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        return customerRepository
                .findById(id)
                .map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
