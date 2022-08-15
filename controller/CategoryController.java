package com.example.project2.controller;


import com.example.project2.Service.CategoryService;
import com.example.project2.modle.Api;
import com.example.project2.modle.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RequiredArgsConstructor
    @RestController
    @RequestMapping("/api/v1/lan")
    public class CategoryController {
        private final CategoryService categoryService;


        @GetMapping("/Category")
        public ResponseEntity getCategory() {
            ArrayList Category=CategoryService.getCategory();
            return ResponseEntity.status(200).body(Category);
        }

        @PostMapping
        public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors) {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new Api(message, 400));
            }
            CategoryService.addCategory(category);
            return ResponseEntity.status(201).body(new Api("New product added !", 201));
        }

        @PutMapping("{index}")
        public ResponseEntity updateCategory(@RequestBody @Valid Category category , @PathVariable int
                index, Errors errors) {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new Api(message, 400));

            }
            CategoryService.updateCategory(index, category);
            return ResponseEntity.status(201).body(new Api("Category updated !", 201));
        }



        @DeleteMapping("{index}")
        public ResponseEntity delCategory(@PathVariable @Valid int index) {
            CategoryService.DelCategory(index);
            return ResponseEntity.status(201).body(new Api("Product deleted", 201));

        }}
