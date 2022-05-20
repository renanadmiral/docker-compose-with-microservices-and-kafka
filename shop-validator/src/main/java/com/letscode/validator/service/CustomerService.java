package com.letscode.validator.service;

import com.letscode.validator.dto.customer.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final WebClient crudWebClient;

    public CustomerDTO getCustomer(String registrationNumber) {

        return crudWebClient
                .get()
                .uri("/customer/{registration}", registrationNumber)
                .retrieve()
                .bodyToMono(CustomerDTO.class)
                .block();
    }
}
