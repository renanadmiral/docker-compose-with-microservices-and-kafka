package com.letscode.validator.service;

import com.letscode.validator.dto.product.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final WebClient crudWebClient;

    public ProductDTO getProduct(String codeNumber) {

        return  crudWebClient
                .get()
                .uri("/product/{codeNumber}", codeNumber)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }
}
