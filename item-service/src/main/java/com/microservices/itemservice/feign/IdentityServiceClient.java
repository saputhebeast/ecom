package com.microservices.itemservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "IDENTITY-SERVICE", url = "${IDENTITY-SERVICE:http://localhost}:8000")
public interface IdentityServiceClient {

    @GetMapping("/api/v1/health")
    ResponseEntity<String> checkHealth();
}
