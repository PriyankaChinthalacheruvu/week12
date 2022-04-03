package com.greatlearning.week9.kafka;

import com.greatlearning.week9.pojo.MessageTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserToUserController {

    private final UserProducer userProducer;


    @Autowired
    public UserToUserController(UserProducer userProducer){
        this.userProducer = userProducer;
    }


    @PostMapping("/usertouser")
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
