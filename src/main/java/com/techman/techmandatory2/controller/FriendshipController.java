package com.techman.techmandatory2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FriendshipController {

    // GREETING CONTROLLER ENDPOINTS (server side)
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
    //ENDPOINTS END







//    @RequestMapping(method = RequestMethod.POST, path = "/friendship")
//    public ResponseEntity<String> postGreetingRoot(@RequestBody Object req){
//        System.out.println("Root request: " + req);
//        return ResponseEntity.ok("Hello from Server 2 (using POST)");
//    }

}

