package com.coderz.f1.reactiondialogtest;

public class Post {
    private String message;
    private LikeValue likeValue;
    public Post(String message, LikeValue likeValue){
        this.message = message;
        this.likeValue = likeValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LikeValue getLikeValue() {
        return likeValue;
    }

    public void setLikeValue(LikeValue likeValue) {
        this.likeValue = likeValue;
    }
}
