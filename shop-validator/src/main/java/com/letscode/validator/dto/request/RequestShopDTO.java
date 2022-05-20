package com.letscode.validator.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestShopDTO {
    private String customerRegistration;
    private List<RequestProductShopDTO> products;
}
