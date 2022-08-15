package com.example.project2.controller;


import com.example.project2.Service.MerchantService;
import com.example.project2.modle.Api;
import com.example.project2.modle.Merchant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RequiredArgsConstructor
    @RestController
    @RequestMapping("/api/v1/dyl")
    public class MerchantController {

        private final MerchantService merchantService;

        @GetMapping("/Merchant")
        public ResponseEntity getMerchant() {
            ArrayList Merchant = MerchantService.getMerchant();
            return ResponseEntity.status(200).body(Merchant);
        }
        @PostMapping
        public ResponseEntity addProduct(@RequestBody @Valid Merchant merchantt, Errors errors) {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new Api(message, 400));
            }
            MerchantService.addMerchant(merchantt);
            return ResponseEntity.status(201).body(new Api("New product added !", 201));
        }

        @PutMapping("{index}")
        public ResponseEntity updateProduct(@RequestBody @Valid Merchant merchantt, @PathVariable int
                index, Errors errors) {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new Api(message, 400));

            }

            MerchantService.updateMerchant(index, merchantt);
            return ResponseEntity.status(201).body(new Api("product updated !", 201));

        }

        @DeleteMapping("{index}")
        public ResponseEntity delProduct(@PathVariable int index) {
            MerchantService.delMerchant(index);
            return ResponseEntity.status(200).body(new Api("product deleted !", 200));
        }

    }
