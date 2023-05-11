package com.messias.hexagonal.application.ports.in;

import com.messias.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
