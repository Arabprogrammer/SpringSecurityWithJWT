package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.UserService;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/admin/all")
    public ResponseEntity<?> findAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }
}
