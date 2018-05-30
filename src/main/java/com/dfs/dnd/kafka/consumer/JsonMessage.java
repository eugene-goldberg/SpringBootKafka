package com.dfs.dnd.kafka.consumer;

/**
 * Created by eugene on 5/30/18.
 */
public class JsonMessage {
    private String header;
    private String body;

    public JsonMessage() {
        super();
    }

    public JsonMessage(String header, String body) {
        super();
        this.header = header;
        this.body = body;
    }
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
