package com.accenture.reactivecrud.service;

import com.accenture.reactivecrud.dto.ProductDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
     //@Autowired
     //private ProductRepository repository;

     public Flux<ProductDto> getProducts(){
         List<ProductDto> listaProductos = new ArrayList<>();
         listaProductos.add(new ProductDto("1","miproductouno",5,5.2d));
         listaProductos.add(new ProductDto("2","miproductodos",6,4.2d));
         listaProductos.add(new ProductDto("3","miproductotres",7,7.2d));
         listaProductos.add(new ProductDto("4","miproductocuatro",8,8.2d));
         return Flux.fromIterable(listaProductos);
     }

     public Mono<ProductDto> getProduct(String id){
         return Mono.just(new ProductDto("4","productocuatro",2,4.3d));
     }


     public Mono<ProductDto> saveProduct(ProductDto productDtoMono){
         ProductDto productMono = new ProductDto();
         productMono.setId(productDtoMono.getId());
         productMono.setName(productDtoMono.getName());
         productMono.setQty(productDtoMono.getQty());
         productMono.setPrice(productDtoMono.getPrice());
         return Mono.just(productMono);

     }

     public Mono<ProductDto> updateProduct(ProductDto productDtoMono, String id){
         ProductDto productMono = new ProductDto("4","productocuatro",2,4.3d);
         productMono.setId(productDtoMono.getId());
         productMono.setName(productDtoMono.getName());
         productMono.setQty(productDtoMono.getQty());
         productMono.setPrice(productDtoMono.getPrice());
         return Mono.just(productMono);
     }




    public Mono<Void> deleteProduct(String id){

        return Mono.empty();
    }
}
