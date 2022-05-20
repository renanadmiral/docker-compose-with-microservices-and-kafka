package com.letscode.mongoproject.dto;

import com.letscode.mongoproject.model.Customer;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerDTO {
    private String name;
    private String registrationNumber;

    public static CustomerDTO convertToDTO(Customer customer) {
        return CustomerDTO.builder()
                .name(customer.getName())
                .registrationNumber(customer.getRegistrationNumber())
                .build();
    }
}
