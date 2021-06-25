package com.omega.framework.core.mq;

import com.omega.framework.core.processor.topic.MessageTopic;

import java.util.List;

/**
 * @Author lviter
 * @Description 消息消费者
 * @Date 16:26 2021/6/25
 * @Desc: Warning!Warning!!Warning!!!
 **/
public interface IMessageConsumer {
    /**
     * 设置序列化器
     *
     * @param serializer
     */
//    void setSerializer(IMessageSerializer serializer);

    /**
     * 接收消息
     *
     * @param topic
     * @param messageType
     * @param size
     * @param <T>
     * @return
     * @throws Exception
     */
    <T> List<T> receive(MessageTopic topic, Class<T> messageType, int size) throws Exception;
}
