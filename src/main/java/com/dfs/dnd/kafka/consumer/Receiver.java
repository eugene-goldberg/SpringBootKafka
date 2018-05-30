package com.dfs.dnd.kafka.consumer;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = "${app.topic.foo}")
    public void listen(@Payload String message) {
        JSONObject jsonMessage = new JSONObject(message);
        String hdr = jsonMessage.get("header").toString();
        String hdrSample = "header-1";
        if(hdr.contentEquals(hdrSample)){
            LOG.info("My Instructions='{}'", jsonMessage.get("body"));
        }
        else {
            LOG.info("this message was not for me");
        }
    }

}
