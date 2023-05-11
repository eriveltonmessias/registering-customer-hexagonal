package com.messias.hexagonal.adapters.in.controller.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
@ToString
@Data
public class CustomerRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    @NotBlank
    private String zipCode;

}
