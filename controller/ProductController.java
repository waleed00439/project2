package com.example.project2.controller;

import com.example.project2.Service.ProductService;
import com.example.project2.modle.Api;
import com.example.project2.modle.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
    @RestController
    @RequestMapping("/api/v1/wee")
    public class ProductController {

        private final ProductService productService;


        @GetMapping("/Product")
        public ResponseEntity getProduct(){
            return ResponseEntity.status(200).body(ProductService.getProduct());
        }

        @PostMapping
        public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors) {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new Api(message, 400));
            }
            ProductService.addProduct(product);
            return ResponseEntity.status(201).body(new Api("New product added !", 201));
        }

        @PutMapping("{index}")
        public ResponseEntity updateProduct(@RequestBody @Valid Product product, @PathVariable int
                index, Errors errors) {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new Api(message, 400));

            }

            ProductService.updateProduct(index, product);
            return ResponseEntity.status(201).body(new Api("product updated !", 201));

        }

        @DeleteMapping("{index}")
        public ResponseEntity delProduct(@PathVariable @Valid int index) {
            productService.delProduct(index);
            return ResponseEntity.status(201).body(new Api("Product updated", 201));
        }
}
