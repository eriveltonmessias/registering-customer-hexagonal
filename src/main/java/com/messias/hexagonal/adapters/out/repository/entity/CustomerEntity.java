package com.messias.hexagonal.adapters.out.repository.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@ToString
@Data
@Document(collation = "Customers")
public class CustomerEntity {

    @Id
    private String id;
    private  String name;
    private AddressEntity address;
    private  String cpf;
    private Boolean isValidCpf;

}
