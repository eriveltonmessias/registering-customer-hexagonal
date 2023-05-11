package com.messias.hexagonal.application.ports.out;

import com.messias.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutPutPort {

    void update(Customer customer);
}
