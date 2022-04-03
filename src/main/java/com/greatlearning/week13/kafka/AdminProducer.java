package com.greatlearning.week13.kafka;

import com.greatlearning.week13.pojo.MessageTemplate;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdminProducer {
    public static final String TOPIC_1 ="admin2user-chat"; //special topic to handle only admin user chat
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate; //custom object json

    public void sendMessageToUser(MessageTemplate message){
        kafkaTemplate.send(TOPIC_1, message);
    }

    @Bean
    public NewTopic createAdminTopic(){
        return new NewTopic(TOPIC_1,3,(short) 1);
    }

}
