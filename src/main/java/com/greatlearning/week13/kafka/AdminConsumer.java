package com.greatlearning.week13.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.greatlearning.week13.pojo.MessageTemplate;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AdminConsumer {


    @KafkaListener(topics="admin2user-chat",groupId = "group_id") // admin chat
    public void consume(ConsumerRecord<String, MessageTemplate> message)throws JsonProcessingException { //using Consumer Record to read message value
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        String jsonString = mapper.writeValueAsString(message.value().toString()); //extracting only message from value
        System.out.println(jsonString);
    }

}
