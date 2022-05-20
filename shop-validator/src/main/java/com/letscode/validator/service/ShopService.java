package com.letscode.validator.service;

import com.letscode.validator.dto.product.ProductDTO;
import com.letscode.validator.dto.request.RequestShopDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final WebClient crudWebClient;

    public ProductDTO postPurchase(RequestShopDTO requestShopDTO) {

        return crudWebClient
                .post()
                .uri("/shop")
                .body(Mono.just(requestShopDTO), RequestShopDTO.class)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }
}
