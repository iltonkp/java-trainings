package io.github.iltonkp.udemy_hexagonal_architecture.adapters.out;

import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.out.SendCpfForValidationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendCpfForValidationAdapter implements SendCpfForValidationOutputPort {

    private KafkaTemplate<String, String> kafkaTemplate

    @Override
    public void send(String cpf) {

        kafkaTemplate.send("tp-cpf-validation", cpf);

    }

}
