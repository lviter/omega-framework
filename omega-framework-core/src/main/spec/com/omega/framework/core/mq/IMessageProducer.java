package com.omega.framework.core.mq;

import com.omega.framework.core.processor.topic.MessageTopic;

/**
 * @Description 消息生产者
 * @Author fang
 * @Date 2020-03-07 18:36
 **/
public interface IMessageProducer {
    /**
     * 设置序列化器
     * @param serializer
     */
//    void setSerializer(IMessageSerializer serializer);

    /**
     * 发送消息
     *
     * @param topic
     * @param messages
     * @throws Exception
     */
    void send(MessageTopic topic, Object... messages) throws Exception;
}
