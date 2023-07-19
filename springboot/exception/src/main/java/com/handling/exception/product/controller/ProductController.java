package com.handling.exception.product.controller;

import com.handling.exception.product.entity.Product;
import com.handling.exception.product.model.ProductInput;
import com.handling.exception.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j(topic = "PRODUCT_CONTROLLER")
@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody @Valid ProductInput input){
        return productService.addProduct(input);
    }

}
