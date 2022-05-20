package com.letscode.validator.kafka;

import com.letscode.validator.dto.customer.CustomerDTO;
import com.letscode.validator.dto.product.ProductDTO;
import com.letscode.validator.dto.request.RequestShopDTO;
import com.letscode.validator.service.CustomerService;
import com.letscode.validator.service.ProductService;
import com.letscode.validator.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiveKafkaMessage {


    public static final String KAFKA_TOPIC = "SHOP_QUEUE";

    private final CustomerService customerService;

    private final ProductService productService;

    private final ShopService shopService;

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "group-1")
    public void listenTopic(RequestShopDTO shopDTO) {

        CustomerDTO customer = customerService.getCustomer(shopDTO.getCustomerRegistration());

        if (customer.getRegistrationNumber() == null)
            throw new RuntimeException("Customer not found");

        shopDTO.getProducts().forEach( p -> {
            ProductDTO product = productService.getProduct(p.getProductCodeNumber());

            if (product.getCodeNumber() == null)
                throw new RuntimeException("Product not found");
        });

        shopService.postPurchase(shopDTO);
    }

}
