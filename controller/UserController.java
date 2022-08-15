package com.example.project2.controller;

import com.example.project2.Service.UserService;
import com.example.project2.modle.Api;
import com.example.project2.modle.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RequiredArgsConstructor
    @RestController
    @RequestMapping("/api/v1/ksa")
    public class UserController {
        private final UserService userService;

        @GetMapping("/Product")
        public ResponseEntity getUser() {
            ArrayList User = UserService.getUser();
            return ResponseEntity.status(200).body(User);
        }
        @PostMapping
        public ResponseEntity addProduct(@RequestBody @Valid User user, Errors errors) {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new Api(message, 400));
            }
            UserService.addUser(user);
            return ResponseEntity.status(201).body(new Api("New product added !", 201));
        }

        @PutMapping("{index}")
        public ResponseEntity updateProduct(@RequestBody @Valid User user, @PathVariable int
                index, Errors errors) {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(new Api(message, 400));

            }

            UserService.updateUser(index, user);
            return ResponseEntity.status(201).body(new Api("product updated !", 201));

        }

        @DeleteMapping("{index}")
        public ResponseEntity delProduct(@PathVariable int index) {

            UserService.delUser(index);
            return ResponseEntity.status(200).body(new Api("product deleted !", 200));
}}
