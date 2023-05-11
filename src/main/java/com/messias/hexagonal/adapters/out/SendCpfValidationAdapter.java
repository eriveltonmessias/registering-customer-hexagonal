package com.messias.hexagonal.adapters.out;

import com.messias.hexagonal.application.ports.out.SendCpfForValidationOutPutPort;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Log4j2
@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutPutPort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        log.info("Publicando cpf {} para validação", cpf);
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }
}
