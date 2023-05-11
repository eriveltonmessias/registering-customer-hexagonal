package com.messias.hexagonal.application.core.usecase;

import com.messias.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.messias.hexagonal.application.core.domain.Address;
import com.messias.hexagonal.application.core.domain.Customer;
import com.messias.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.messias.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.messias.hexagonal.application.ports.out.InsertCustomerOutPutPort;
import com.messias.hexagonal.application.ports.out.SendCpfForValidationOutPutPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;
    private final InsertCustomerOutPutPort insertCustomerOutPutPort;

    private final SendCpfForValidationOutPutPort sendCpfForValidationOutPutPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
                                 InsertCustomerOutPutPort insertCustomerOutPutPort,
                                 SendCpfForValidationOutPutPort sendCpfForValidationOutPutPort){

        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.insertCustomerOutPutPort = insertCustomerOutPutPort;
        this.sendCpfForValidationOutPutPort = sendCpfForValidationOutPutPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        Address address = findAddressByZipCodeOutPutPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutPutPort.insert(customer);
        sendCpfForValidationOutPutPort.send(customer.getCpf());

    }
}
