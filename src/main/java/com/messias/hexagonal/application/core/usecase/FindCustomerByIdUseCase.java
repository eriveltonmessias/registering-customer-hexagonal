package com.messias.hexagonal.application.core.usecase;

import com.messias.hexagonal.application.core.domain.Customer;
import com.messias.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.messias.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutPutPort findCustomerByIdOutPutPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutPutPort findCustomerByIdOutPutPort){
        this.findCustomerByIdOutPutPort = findCustomerByIdOutPutPort;
    }

    @Override
    public Customer find(String id){
       return  this.findCustomerByIdOutPutPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
