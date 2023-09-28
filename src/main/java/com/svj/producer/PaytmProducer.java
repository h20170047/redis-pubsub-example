package com.svj.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.svj.dto.PaymentRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaytmProducer {
    private ChannelTopic channelTopic;
    private StringRedisTemplate template;
    private ObjectMapper objectMapper;

    public String doTransaction(PaymentRequest request){
        try {
            template.convertAndSend(channelTopic.getTopic(),
                    objectMapper.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Payment request initiated";
    }
}
