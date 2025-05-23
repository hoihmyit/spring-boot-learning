package com.spl.hm.springboot_kafka.dto;

public class UserMessage {
    private String id;
    private String name;

    public UserMessage() {
    }

    public UserMessage(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
