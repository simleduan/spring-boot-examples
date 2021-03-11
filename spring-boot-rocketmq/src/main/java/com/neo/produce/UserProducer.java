package com.neo.produce;

import com.alibaba.fastjson.JSON;
import com.neo.entity.UserContent;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * create by xiaocai on 2021/3/8 11:22
 **/
@Component
@EnableScheduling
public class UserProducer {
    /**
     * 生产者的组名
     */
    @Value("${lili.rocketmq.produce}")
    private String producerGroup;

    /**
     * NameServer 地址
     */
    @Value("${lili.rocketmq.nameserver}")
    private String namesrvAddr;

    @Scheduled(cron = "0/5 * * * * ? ")
    public void produder() {
        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(namesrvAddr);
        try {
            producer.start();
            String format = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
            UserContent userContent = new UserContent(format,"pwd:"+format);
            String jsonstr = JSON.toJSONString(userContent);
            System.out.println("发送消息:"+jsonstr);
            Message message = new Message("user-topic", "user-tag", jsonstr.getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult result = producer.send(message);
            System.err.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
}
