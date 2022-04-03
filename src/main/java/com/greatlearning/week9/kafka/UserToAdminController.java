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
public class UserToAdminController {

    private final UserProducer userProducer;
    private final AdminProducer adminProducer;

    @Autowired
    public UserToAdminController(UserProducer userProducer, AdminProducer adminProducer){
        this.userProducer = userProducer;
        this.adminProducer = adminProducer;
    }


    @PostMapping("/publish/user")
    public void userMessageWindow(@RequestParam("message") String msg){
        MessageTemplate message = new MessageTemplate();
        message.setMessage(msg);
        message.setRole("USER"); //already checked user role in WebSecurityConfig Class --can't reach here if not USER

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName(); //getting logged in username

        message.setUsername(currentPrincipalName); //adding username in message box

        this.userProducer.sendMessageToAnotherUser(message);
    }

    @PostMapping("/publish/admin")
    public void adminMessageWindow(@RequestParam("message") String msg){
        MessageTemplate message = new MessageTemplate();
        message.setMessage(msg);
        message.setRole("ADMIN"); //already checked user role in WebSecurityConfig Class --can't reach here if not ADMIN

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName(); //getting logged in username

        message.setUsername(currentPrincipalName); //adding username in message box

        this.userProducer.sendMessageToAnotherUser(message);
    }

}
