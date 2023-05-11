package com.messias.hexagonal.adapters.out;

import com.messias.hexagonal.adapters.out.repository.CustomerRepository;
import com.messias.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
    customerRepository.deleteById(id);
    }
}
