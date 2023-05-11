package com.messias.hexagonal.application.core.usecase;

import com.messias.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.messias.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.messias.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutPutPort deleteCustomerByIdOutPutPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOutPutPort deleteCustomerByIdOutPutPort){
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutPutPort = deleteCustomerByIdOutPutPort;
    }

@Override
    public void delete(String id){
        this.findCustomerByIdInputPort.find(id);
        this.deleteCustomerByIdOutPutPort.delete(id);

    }
}
