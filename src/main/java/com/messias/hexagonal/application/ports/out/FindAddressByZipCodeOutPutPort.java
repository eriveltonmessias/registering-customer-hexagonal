package com.messias.hexagonal.application.ports.out;

import com.messias.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutPutPort {
    Address find(String zipCode);
}
