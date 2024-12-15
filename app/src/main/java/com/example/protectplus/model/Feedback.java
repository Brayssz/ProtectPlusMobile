package com.example.protectplus.model;

public class Feedback {
    private int avatarResource;
    private String feedbackText;
    private boolean isAvatarLeft;

    public Feedback(int avatarResource, String feedbackText, boolean isAvatarLeft) {
        this.avatarResource = avatarResource;
        this.feedbackText = feedbackText;
        this.isAvatarLeft = isAvatarLeft;
    }

    public int getAvatarResource() {
        return avatarResource;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public boolean isAvatarLeft() {
        return isAvatarLeft;
    }
}
