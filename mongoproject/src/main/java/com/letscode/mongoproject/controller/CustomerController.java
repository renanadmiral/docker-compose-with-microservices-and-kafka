package com.letscode.mongoproject.controller;

import com.letscode.mongoproject.dto.CustomerDTO;
import com.letscode.mongoproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{registration}")
    public CustomerDTO getCustomer(@PathVariable String registration) {
        return customerService.getCustomer(registration);
    }

    @PostMapping
    public CustomerDTO postCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.postCustomer(customerDTO);
    }
}
