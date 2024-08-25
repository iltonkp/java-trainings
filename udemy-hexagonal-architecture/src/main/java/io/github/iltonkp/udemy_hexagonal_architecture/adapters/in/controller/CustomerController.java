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
@RequestMapping(name = "/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private InsertCustomerInputPort insertCustomerInputPort;
    private FindCustomerByIdInputPort findCustomerByIdInputPort;
    private UpdateCustomerInputPort updateCustomerInputPort;
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insertCustomer(@Valid @RequestBody CustomerRequestDto customer) {

        insertCustomerInputPort.insert(customerMapper.toCustomer(customer), customer.zipCode());
        return ResponseEntity.ok().build();

    }

    @GetMapping(name = "/{id}")
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable(name = "id") final String id){

        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponseDto(customer);
        return ResponseEntity.ok().body(customerResponse);

    }

    @PutMapping(name = "/{id}")
    public ResponseEntity<Void> update(
            @PathVariable(name = "id") final String id,
            @Valid @RequestBody CustomerRequestDto customerRequest
    ){

        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.zipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(name = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") final String id){

        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();

    }

}
