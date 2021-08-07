package com.accenture.reactivecrud.controller;

import com.accenture.reactivecrud.dto.ProductDto;
import com.accenture.reactivecrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Flux<ProductDto> getProducts(){
    return service.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProducts(@PathVariable String id){
        return service.getProduct(id);
    }

    @PostMapping("/save")
    public Mono<ProductDto> saveProduct(@RequestBody ProductDto productDtoMono){
        return service.saveProduct(productDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateProduct(@RequestBody ProductDto productDtoMono,@PathVariable String id){
        return service.updateProduct(productDtoMono,id);
    }


    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return service.deleteProduct(id);
    }

}
