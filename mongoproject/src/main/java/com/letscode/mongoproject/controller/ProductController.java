package com.letscode.mongoproject.controller;

import com.letscode.mongoproject.dto.ProductDTO;
import com.letscode.mongoproject.model.Product;
import com.letscode.mongoproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDTO postProduct(@RequestBody ProductDTO product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{codeNumber}")
    public Product getAllProducts(@PathVariable String codeNumber) {
        return productService.findByCode(codeNumber);
    }
}
