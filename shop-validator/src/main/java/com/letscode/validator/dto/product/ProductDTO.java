package com.letscode.validator.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String codeNumber;
    private Float price;
    private Integer stockAmmount;
}
