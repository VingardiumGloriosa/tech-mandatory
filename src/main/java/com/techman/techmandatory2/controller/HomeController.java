package com.techman.techmandatory2.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    // GREETING CONTROLLER ENDPOINTS (client side)

    final String API_GREETING_GET = "http://localhost:9091/apiGreetingGet?greeting=hi from client GET";
    final String API_GREETING_POST = "http://localhost:9091/apiGreetingPost";
    private RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/sendGetGreeting")
    public String sendGetGreeting(Model model) {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("greeting", "Hello there");
        ResponseEntity response = restTemplate.getForEntity(API_GREETING_GET, String.class);
        model.addAttribute("greeting", response.getBody());
        return "index";
    }

    @PostMapping("/sendPostGreeting")
    public String sendGreeting(Model model) {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("greeting", "Hello there from client POST");
        ResponseEntity response = restTemplate.postForEntity(API_GREETING_POST, reqMap, String.class);
        model.addAttribute("greeting", response.getBody());
        return "index";
    }

//    final String API_GREETING_POST = "http://localhost:9091/friendship";
//    @PostMapping("/sendPostGreeting")
//    public String sendGreeting(Model model){
//        WebClient webClient = WebClient.builder()
//                .baseUrl(API_GREETING_POST)
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//
//                String request = "\"hi from client\"";
//                String key = "\"request\"";
//                String response = webClient.post()
//                        .body(Mono.just("{"+ key +":"+ request +"}"), String.class)
//                        .retrieve()
//                        .bodyToMono(String.class)
//                        .block();
//                model.addAttribute("greeting", response);
//                return "index";
//    }


}
