package com.letscode.mongoproject.kafka;

import com.letscode.mongoproject.dto.ShopDTO;
import com.letscode.mongoproject.dto.request.RequestShopDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaSendMessage {
    private final KafkaTemplate<String, RequestShopDTO> kafkaTemplate;

    public static final String KAFKA_TOPIC = "SHOP_QUEUE";

    public RequestShopDTO sendMessage(RequestShopDTO shop) {
        kafkaTemplate.send(KAFKA_TOPIC, shop);
        return shop;
    }
}
