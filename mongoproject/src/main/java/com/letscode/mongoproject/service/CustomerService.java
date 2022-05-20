package com.letscode.mongoproject.service;

import com.letscode.mongoproject.dto.CustomerDTO;
import com.letscode.mongoproject.model.Customer;
import com.letscode.mongoproject.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerDTO getCustomer(String customerRegistration) {

        Customer nullCustomer = Customer.builder()
                .id(null)
                .name(null)
                .registrationNumber(null)
                .build();

        Customer customer = customerRepository.findByRegistrationNumber(customerRegistration)
                .orElse(nullCustomer);

        return CustomerDTO.convertToDTO(customer);
    }

    public CustomerDTO postCustomer(CustomerDTO reqCustomerDTO) {

        Customer customer = Customer.builder()
                .id(UUID.randomUUID().toString())
                .name(reqCustomerDTO.getName())
                .registrationNumber(reqCustomerDTO.getRegistrationNumber())
                .build();

        customerRepository.save(customer);

        return reqCustomerDTO;
    }
}
