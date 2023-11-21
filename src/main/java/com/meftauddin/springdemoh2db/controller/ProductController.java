package com.meftauddin.springdemoh2db.controller;

import com.meftauddin.springdemoh2db.entity.Product;
import com.meftauddin.springdemoh2db.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }
    @DeleteMapping("/delete")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

}
