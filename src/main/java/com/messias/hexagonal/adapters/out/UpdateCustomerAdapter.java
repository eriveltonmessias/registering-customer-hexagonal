package com.messias.hexagonal.adapters.out;

import com.messias.hexagonal.adapters.out.repository.CustomerRepository;
import com.messias.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.messias.hexagonal.application.core.domain.Customer;
import com.messias.hexagonal.application.ports.out.UpdateCustomerOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    CustomerEntityMapper customerEntityMapper;
    @Override
    public void update(Customer customer) {
        customerRepository.save(customerEntityMapper.toCustomerEntity(customer));

    }
}
