package com.example.demo.service.user.impl;

import com.example.demo.service.user.IUserService;
import com.example.demo.util.FastApiClient;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private FastApiClient fastApiClient;

    @Value("${url:http://localhost:9000/}")
    private String fastApiUrl;

    @Override
    public ResponseEntity<String> login(Map<String, Object> userData) {
        return fastApiClient.invoke(fastApiUrl, "/login", userData);
    }

    @Override
    public ResponseEntity<String> register(Map<String, Object> userData) {
        return fastApiClient.invoke(fastApiUrl, "/register", userData);
    }
}
