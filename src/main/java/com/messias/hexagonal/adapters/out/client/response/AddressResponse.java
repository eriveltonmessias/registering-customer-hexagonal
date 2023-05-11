package com.messias.hexagonal.adapters.out.client.response;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class AddressResponse {

    private String street;
    private String city;
    private String state;
}
