package com.messias.hexagonal.adapters.out;

import com.messias.hexagonal.adapters.out.repository.CustomerRepository;
import com.messias.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.messias.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.messias.hexagonal.application.core.domain.Customer;
import com.messias.hexagonal.application.ports.out.InsertCustomerOutPutPort;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class InsertCustomerAdapter implements InsertCustomerOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        log.info("Salvar cliente na base: {}", customer);
        CustomerEntity customerEntity =  customerEntityMapper.toCustomerEntity(customer);
        log.info("Convertido para o objeto da base: {}", customerEntity);
        customerRepository.save(customerEntity);
    }
}
