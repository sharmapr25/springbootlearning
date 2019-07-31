package com.learning.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("/")
    public Page<Product> getAllProducts() {
        return productService.getProductsWithFirstPage();
    }

    @GetMapping("/fetch/{money}")
    public List<Product> getAllProductsBasedOnMoney(@PathVariable int money){
        return productService.getProductBasedOnMoney(money);
    }

    @GetMapping("/sort/name")
    public Iterable<Product> getAllProductSortByName(){
        return productService.sortProductsBasedOnName();
    }

    @GetMapping("/sort/price")
    public Iterable<Product> getAllProductSortByPrice(){
        return productService.sortProductsBasedOnPrice();
    }
}
