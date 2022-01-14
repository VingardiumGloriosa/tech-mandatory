package com.techman.techmandatory2.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Controller
public class HomeController {
    final String API_GREETING_POST = "http://localhost:9091/friendship";
    @PostMapping("/sendPostGreeting")
    public String sendGreeting(Model model){
        WebClient webClient = WebClient.builder()
                .baseUrl(API_GREETING_POST)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

                String request = "\"hi from client\"";
                String key = "\"request\"";
                String response = webClient.post()
                        .body(Mono.just("{"+ key +":"+ request +"}"), String.class)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
                model.addAttribute("greeting", response);
                return "index";
    }


}
