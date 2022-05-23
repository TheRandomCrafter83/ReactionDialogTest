package com.coderz.f1.reactiondialogtest;

/**
 * An object representation of a Post
 */
public class Post {
    private String message;
    private LikeValue likeValue;
    public Post(String message, LikeValue likeValue){
        this.message = message;
        this.likeValue = likeValue;
    }

    /**
     * @return Gets the message to be displayed
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message Sets the message of the Post
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return Gets the Like value of the Post
     */
    public LikeValue getLikeValue() {
        return likeValue;
    }

    /**
     * @param likeValue Sets the value of the like
     */
    public void setLikeValue(LikeValue likeValue) {
        this.likeValue = likeValue;
    }
}
