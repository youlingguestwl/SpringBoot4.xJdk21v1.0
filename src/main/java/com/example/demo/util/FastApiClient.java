package com.example.demo.util;

import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Component
public class FastApiClient {

    @Resource
    private RestTemplate restTemplate;

    public ResponseEntity<String> invoke(String fastApiUrl, String fastApiUrlExt, Map<String, Object> userData) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(userData, headers);
        try {
            return restTemplate.postForEntity(fastApiUrl + fastApiUrlExt, request, String.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

}
