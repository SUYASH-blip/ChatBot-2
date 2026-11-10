package org.example.chatbot2.controller;


import org.apache.http.HttpStatus;
import org.example.chatbot2.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping
    public String get(){
        return "Hello";
    }

    @GetMapping("/chat")
    public ResponseEntity<String> ask(@RequestBody String prompt){
        String response = chatService.generateResponse(prompt);
        return
                ResponseEntity.status(HttpStatus.SC_OK).body(response);
    }
}

