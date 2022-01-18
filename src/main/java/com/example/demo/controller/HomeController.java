package com.example.demo.controller;

import com.example.demo.model.Friendship2;
import com.example.demo.model.Protocol;
import com.example.demo.service.FriendshipService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    FriendshipService friendshipService;

    private RestTemplate restTemplate = new RestTemplate();
    private static String currentHost = "http://localhost:9091/";

    public HomeController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    //FRIENDSHIP REQUEST SENT
    @PostMapping("/sendFriendship")
    public String sendFriendshipRequest(Model model, @ModelAttribute Protocol protocol) {
        Protocol request = new Protocol(protocol.toString());
        System.out.println(request);
        String URL = request.getDEST_Host() + "/handleFriendship";
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("SRC", request.getSRC());
        reqMap.put("SRC Host", request.getSRC_Host());
        reqMap.put("DEST", request.getDEST());
        reqMap.put("DEST Host", request.getDEST_Host());
        reqMap.put("Version", request.getVersion());
        ResponseEntity<String> response = restTemplate.postForEntity(URL, reqMap, String.class);
        Friendship2 friendship = friendshipService.handleFriendship(request);
        model.addAttribute("status",friendship.getSrcUserEmail() + " => "+ friendship.getDestUserEmail()
                                +"\nFriendship status:" + friendship.getStatus());
        System.out.println(response.getBody());
        model.addAttribute("response", response.getBody());
        return "index";
    }

    //FRIENDSHIP REQUEST RECEIVED
    @PostMapping("/handleFriendship")
    public ResponseEntity<String> handleFriendshipRequest(@RequestBody Map<String,String> req, Model model) {
        System.out.println(req);
        Protocol request = new Protocol(req);
        if (request.getDEST_Host().equals(currentHost)) {
            Friendship2 friendship = friendshipService.handleFriendship(request);
            model.addAttribute("status",friendship.getSrcUserEmail() + " => "+ friendship.getDestUserEmail()
                    +"\nFriendship status:" + friendship.getStatus());
            return ResponseEntity.ok("Request handled! Status: " + friendship.getStatus());
        }
        return ResponseEntity.ok("Request handled but something went wrong");
    }



    // GREETING CONTROLLER ENDPOINTS (client side)

    final String API_GREETING_GET = "http://localhost:9091/apiGreetingGet?greeting=hi from client GET";
    final String API_GREETING_POST = "http://localhost:9091/apiGreetingPost";
//    private RestTemplate restTemplate = new RestTemplate();

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
