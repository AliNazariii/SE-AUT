package com.muhmdreza.foodorderingsystem.Models;

import java.io.Serializable;

public class CommentItem implements Serializable {
    private String message;
    private String foodName;
    private boolean approved;

    public CommentItem(String message, String foodName) {
        this.message = message;
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getMessage() {
        return message;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
