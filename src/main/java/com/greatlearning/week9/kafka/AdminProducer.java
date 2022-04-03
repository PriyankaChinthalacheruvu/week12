package com.greatlearning.week9.kafka;

import com.greatlearning.week9.pojo.MessageTemplate;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdminProducer {
    public static final String TOPIC_1 ="admin2user-chat";
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToUser(MessageTemplate message){
        kafkaTemplate.send(TOPIC_1, message);
    }

    @Bean
    public NewTopic createAdminTopic(){
        return new NewTopic(TOPIC_1,3,(short) 1);
    }

}
