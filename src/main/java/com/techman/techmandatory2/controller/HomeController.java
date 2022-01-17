package com.techman.techmandatory2.controller;

import com.techman.techmandatory2.model.Protocol;
import com.techman.techmandatory2.service.FriendshipService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    FriendshipService friendshipService;

    public HomeController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    private RestTemplate restTemplate = new RestTemplate();

    private static String currentHost = System.getenv("IP_ADDRESS");

    @PostMapping("/friendship")
    public ResponseEntity<String> friendship(@RequestBody String req) {

        Protocol request = new Protocol(req);
        if (request.getDEST_Host().equals(currentHost)) {
            friendshipService.handleFriendship(request);
            return ResponseEntity.ok("Response Handled");
        }

        else {
            String REQUEST_URL = request.getDEST_Host() + "/friendship";
          Map<String, String> reqMap = new HashMap<>();
          reqMap.put("SRC", "email@email.com"); //fill in with the data from the PROTOCOL (request)
          reqMap.put("SRC Host", "Facebook");
          reqMap.put("DEST", "email@email.com");
          reqMap.put("DEST Host", "Instagram");
            restTemplate.postForEntity(REQUEST_URL, reqMap, String.class);
        }
        return ResponseEntity.ok("Done");
    }


//    final String API_ADD_FRIEND = "http://localhost:9091/addFriend";
//    final String API_ACCEPT_FRIENDSHIP = "";
//    final String API_DENY_FRIENDSHIP = "";
//    final String API_REMOVE_FRIENDSHIP = "";
//    final String API_BLOCK_USER = "";
//
//    @PostMapping("/addFriend")
//    public String addFriend(Model model) {
//        Map<String, String> reqMap = new HashMap<>();
//        reqMap.put("SRC", "email@email.com");
//        reqMap.put("SRC Host", "Facebook");
//        reqMap.put("DEST", "email@email.com");
//        reqMap.put("DEST Host", "Instagram");
//        ResponseEntity response = restTemplate.postForEntity(API_GREETING_POST, reqMap, String.class);
//        model.addAttribute("greeting", response.getBody());
//        return "index";
//    }
//
//    @PostMapping("/acceptFriendship")
//    public String acceptFriend(Model model) {
//        return "index";
//    }
//
//    @PostMapping("/denyFriendship")
//    public String denyFriendship(Model model) {
//        return "index";
//    }
//
//    @PostMapping("/removeFriendship")
//    public String removeFriendship(Model model) {
//        return "index";
//    }
//
//    @PostMapping("/blockUser")
//    public String blockUser(Model model) {
//        return "index";
//    }



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
