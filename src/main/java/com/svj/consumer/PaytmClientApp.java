package com.svj.consumer;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

public class PaytmClientApp implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("PaytmClientApp consumed events -> "+message);
    }
}
