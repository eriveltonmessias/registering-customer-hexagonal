package com.messias.hexagonal.application.ports.out;

public interface SendCpfForValidationOutPutPort {

    void send(String cpf);
}
