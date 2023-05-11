package com.messias.hexagonal.application.core.usecase;

import com.messias.hexagonal.application.core.domain.Address;
import com.messias.hexagonal.application.core.domain.Customer;
import com.messias.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.messias.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.messias.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.messias.hexagonal.application.ports.out.UpdateCustomerOutPutPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private  final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;
    private final UpdateCustomerOutPutPort updateCustomerOutPutPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
                                 UpdateCustomerOutPutPort updateCustomerOutPutPort){
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.updateCustomerOutPutPort = updateCustomerOutPutPort;
    }

    public  void update(Customer customer, String zipCode){
        findCustomerByIdInputPort.find(customer.getId());
        Address address = this.findAddressByZipCodeOutPutPort.find(zipCode);
        customer.setAddress(address);
        this.updateCustomerOutPutPort.update(customer);


    }
}
