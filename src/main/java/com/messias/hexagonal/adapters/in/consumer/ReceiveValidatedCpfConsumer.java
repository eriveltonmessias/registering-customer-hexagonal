package com.messias.hexagonal.adapters.in.consumer;

import com.messias.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.messias.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.messias.hexagonal.application.core.domain.Customer;
import com.messias.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

@Autowired
private CustomerMessageMapper customerMessageMapper;

@Autowired
private UpdateCustomerInputPort updateCustomerInputPort;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "messias")
    public void receive(CustomerMessage customerMessage){
        Customer customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
