package com.letscode.mongoproject.dto.request;

import com.letscode.mongoproject.dto.ShopProductDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class RequestShopDTO {
    private String customerRegistration;

    private List<ShopProductDTO> products;
}
