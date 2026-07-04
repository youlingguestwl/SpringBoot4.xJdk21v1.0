package com.example.demo.controller.user;

import com.example.demo.service.user.IUserService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    @Resource
    private IUserService iUserService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, Object> userData) {
        return iUserService.login(userData);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, Object> userData) {
        return iUserService.register(userData);
    }
}