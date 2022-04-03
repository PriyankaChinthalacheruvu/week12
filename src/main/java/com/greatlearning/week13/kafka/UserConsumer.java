package com.greatlearning.week13.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.greatlearning.week13.pojo.MessageTemplate;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @KafkaListener(topics="admin2user-chat",groupId = "group_id") //custom listener for admin - user chat
    public void consumeUserToAdmin(ConsumerRecord<String, MessageTemplate> message)throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        String jsonString = mapper.writeValueAsString(message.value().toString()); //custom message json
        System.out.println(jsonString);
    }

    @KafkaListener(topics="user2user-chat",groupId = "group_id") //custom listener for user - user chat
    public void consumeUserToUser(ConsumerRecord<String, MessageTemplate> message)throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        String jsonString = mapper.writeValueAsString(message.value().toString()); //custom message json reading
        System.out.println(jsonString);
    }

}
