package com.greatlearning.week13.kafka;

import com.greatlearning.week13.pojo.MessageTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserToUserController { // Endpoint to handle User-User chat window

    private final UserProducer userProducer;


    @Autowired
    public UserToUserController(UserProducer userProducer){
        this.userProducer = userProducer;
    }


    @PostMapping("/usertouser") //end point for user to ping chat in diff browsers/sessions
    public void userMessageWindow(@RequestParam("message") String msg){
        MessageTemplate message = new MessageTemplate();
        message.setMessage(msg);
        message.setRole("USER"); //already checked user role in WebSecurityConfig Class --can't reach here if not USER

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName(); //getting logged in username

        message.setUsername(currentPrincipalName); //adding username in message box

        this.userProducer.sendMessageToAnotherUser(message);
    }



}
