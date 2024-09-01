package io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.consumer;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.consumer.mapper.CustomerMessageMapper;
import io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.consumer.message.CustomerMessage;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in.UpdateCustomerInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReceiveValidatedCpfConsumer {

    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "iltonkp")
    public void receive( CustomerMessage customerMessage) {

        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());

    }

}
