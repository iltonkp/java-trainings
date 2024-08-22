package io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.controller;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.controller.mapper.CustomerMapper;
import io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.controller.request.CustomerRequestDto;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private InsertCustomerInputPort insertCustomerInputPort;
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insertCustomer(@Valid @RequestBody CustomerRequestDto customer) {
        insertCustomerInputPort.insert(customerMapper.toCustomer(customer), customer.zipCode());

        return ResponseEntity.ok().build();
    }

}
