package com.example.demo.service.user;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IUserService {
    ResponseEntity<String> login(Map<String, Object> userData);

    ResponseEntity<String> register(Map<String, Object> userData);
}
