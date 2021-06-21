package com.example.springbootasm2.controller;


import com.example.springbootasm2.entity.Product;
import com.example.springbootasm2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public List<Product> generateProduct(){

        List<Product> list = new ArrayList<Product>();
        Product product1 = new Product("sach",200);
        list.add(product1);
        Product product2 = new Product("khau trang",100);
        list.add(product2);  Product product3 = new Product("vo",300);
        list.add(product3);  Product product4 = new Product("but chi",500);
        list.add(product4);  Product product5 = new Product("tay",600);
        list.add(product5);  Product product6 = new Product("chuot",200);
        list.add(product6);  Product product7 = new Product("vi",900);
        list.add(product7);  Product product8 = new Product("loa",800);
        list.add(product8);  Product product9 = new Product("bim bim",300);
        list.add(product9);  Product product10 = new Product("chieu",1500);
        list.add(product10);

        return list;
    }


    @RequestMapping(value = "/getDetail",method = RequestMethod.GET)
    public Optional<Product> getDetail(@RequestParam Integer id){
        Optional<Product> product = productRepository.findById(id);
        return product;
    }
}
