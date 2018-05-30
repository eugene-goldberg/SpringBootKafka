package com.dfs.dnd.kafka;

import com.dfs.dnd.kafka.consumer.JsonMessage;
import com.dfs.dnd.kafka.producer.Sender;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SpringBootApplication
public class ProducerConsumerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProducerConsumerApplication.class, args);
    }

    @Autowired
    private Sender sender;

    @Override
    public void run(String... strings) throws Exception {
        JsonMessage msg = new JsonMessage("header-1","body-1");
        Gson gson = new GsonBuilder().create();
        String jsonString = gson.toJson(msg);
        try {
            JSONObject request = new JSONObject(jsonString);
            sender.send(request.toString());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}