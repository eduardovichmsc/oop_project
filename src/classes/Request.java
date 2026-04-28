package classes;

import abstracts.User;
import enums.RequestType;

public class Request {
    private User sender;
    private String topic;
    private String message;
    private RequestType type;
    private boolean isResolved;

    public Request(User sender, String topic, String message, RequestType type) {
        this.sender = sender;
        this.topic = topic;
        this.message = message;
        this.type = type;
        this.isResolved = false;
    }

    // getters & setters
    public User getSender() {
        return sender;
    }
    public void setSender(User sender) {
        this.sender = sender;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public RequestType getType() {
        return type;
    }
    public void setType(RequestType type) {
        this.type = type;
    }
    public boolean isResolved() {
        return isResolved;
    }
    public void setResolved(boolean isResolved) {
        this.isResolved = isResolved;
    }
}
