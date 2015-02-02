package com.kodepelangi.entity;

/**
 * @author Raka Teja<rakatejaa@gmail.com>
 */
public class Message {
    private Long id;
    private String message;
    private String from;

    public Message(Long id, String message, String from)
    {
        this.id = id;
        this.message = message;
        this.from = from;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
