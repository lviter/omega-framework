package com.omega.framework.core.processor.topic;

/**
 * @Description topic
 * @Author fang
 * @Date 2020-03-07 18:39
 **/
public class MessageTopic {
    private String topicName;

    public MessageTopic() {
    }

    public MessageTopic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
