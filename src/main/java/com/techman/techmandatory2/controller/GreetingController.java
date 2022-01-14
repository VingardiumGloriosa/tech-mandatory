package com.techman.techmandatory2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @RequestMapping(method = RequestMethod.POST, path = "/friendship")
    public ResponseEntity<String> postGreetingRoot(@RequestBody Object req){
        System.out.println("Root request: " + req);
        return ResponseEntity.ok("Hello from Server 2 (using POST)");
    }
}
