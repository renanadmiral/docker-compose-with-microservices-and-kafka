package com.letscode.mongoproject.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductsDTO {
    private List<ProductDTO> products;
}
