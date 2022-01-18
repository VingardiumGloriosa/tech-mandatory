package com.example.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

    @RestController
    public class Rest {

        //GREETING REST ENDPOINTS (SERVER SIDE)
        @GetMapping("apiGreetingGet")
        public ResponseEntity<String> getGreeting(@RequestParam("greeting") String req) {
            System.out.println("apiGreeting called with " + req);
            return ResponseEntity.ok("Hello from Server 2 (using GET)");
        }

        @PostMapping("apiGreetingPost")
        public ResponseEntity<String> postGreeting(@RequestBody Map<String, String> req) {
            System.out.println("Request: " + req.get("greeting"));
            return ResponseEntity.ok("Hello from Server 2 (using POST)");
        }
        //
    }
