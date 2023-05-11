package com.messias.hexagonal.adapters.in.controller;

import com.messias.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.messias.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.messias.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.messias.hexagonal.application.core.domain.Customer;
import com.messias.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.messias.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.messias.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.messias.hexagonal.application.ports.in.UpdateCustomerInputPort;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {

        log.info("Criar cliente: {}", customerRequest);
        Customer customer = customerMapper.toCustomer(customerRequest);
        log.info("Cliente convertido para modelo: {}", customer);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        CustomerResponse customerResponse = customerMapper.toCustomerResponse(this.findCustomerByIdInputPort.find(id));
        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void>update(@PathVariable String id, @Valid @RequestBody CustomerRequest customerRequest){
            Customer customer =  this.customerMapper.toCustomer(customerRequest);
            customer.setId(id);
            this.updateCustomerInputPort.update(customer, customerRequest.getZipCode());

            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable String id){
        this.deleteCustomerByIdInputPort.delete(id);

        return ResponseEntity.noContent().build();
    }
}
