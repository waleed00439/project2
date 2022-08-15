package com.example.project2.controller;

import com.example.project2.Service.MerchantStockService;
import com.example.project2.modle.Api;
import com.example.project2.modle.MerchantStock;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RequiredArgsConstructor
    @RestController
    @RequestMapping("/api/v1/SSA")
    public class MerchantStockController {

        private final MerchantStockService merchantStockService;

        @GetMapping("/MerchantStock")
        public ResponseEntity getMerchantStock() {
            ArrayList MerchantStock = MerchantStockService.getMerchantStock();
            return ResponseEntity.status(200).body(MerchantStock);
        }
        @PostMapping
        public ResponseEntity addProduct(@RequestBody @Valid MerchantStock merchant, Errors errors) {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new Api(message, 400));
            }
            MerchantStockService.addMerchantStock(merchant);
            return ResponseEntity.status(201).body(new Api("New product added !", 201));
        }

        @PutMapping("{index}")
        public ResponseEntity updateProduct(@RequestBody @Valid MerchantStock merchant, @PathVariable int
                index, Errors errors) {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new Api(message, 400));

            }
            MerchantStockService.updateMerchantStock(index, merchant);
            return ResponseEntity.status(201).body(new Api("product updated !", 201));

        }

        @DeleteMapping("{index}")
        public ResponseEntity delProduct(@PathVariable int index) {

            MerchantStockService.delMerchantStock(index);
            return ResponseEntity.status(200).body(new Api("product deleted !", 200));
        }
}
