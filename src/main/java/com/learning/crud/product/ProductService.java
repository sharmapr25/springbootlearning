package com.learning.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Page<Product> getProductsWithFirstPage(){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);


        return productRepository.findAll(firstPageWithTwoElements);
    }

    public List<Product> getProductBasedOnMoney(int money){
        Pageable secondPageWithFiveElements = PageRequest.of(0, 2);
        return productRepository.findAllByPrice(money, secondPageWithFiveElements);
    }

    public Iterable<Product> sortProductsBasedOnName(){
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Iterable<Product> sortProductsBasedOnPrice() {
        return productRepository.findAll(Sort.by("price"));
    }
}

