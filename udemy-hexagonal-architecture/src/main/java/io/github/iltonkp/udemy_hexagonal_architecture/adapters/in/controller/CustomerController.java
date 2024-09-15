package io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.controller;

import io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.controller.mapper.CustomerMapper;
import io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.controller.request.CustomerRequestDto;
import io.github.iltonkp.udemy_hexagonal_architecture.adapters.in.controller.response.CustomerResponseDto;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in.DeleteCustomerByIdInputPort;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in.FindCustomerByIdInputPort;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in.InsertCustomerInputPort;
import io.github.iltonkp.udemy_hexagonal_architecture.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
    private final CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insertCustomer(@Valid @RequestBody CustomerRequestDto customer) {

        insertCustomerInputPort.insert(customerMapper.toCustomer(customer), customer.zipCode());
        return ResponseEntity.ok().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable("id") final String id){

        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponseDto(customer);
        return ResponseEntity.ok().body(customerResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable(name = "id") final String id,
            @Valid @RequestBody CustomerRequestDto customerRequest
    ){

        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.zipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id){

        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();

    }

}
