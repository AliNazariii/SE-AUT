package com.muhmdreza.foodorderingsystem.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuItem implements Serializable {
    private String id;
    private String price;
    private String category;
    private String name;
    private String description;
    private String count;
    private String available;
    private String imageUrl;
    private List<CommentItem> commentItems = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCommentItems(CommentItem commentItem) {
        this.commentItems.add(commentItem);
    }

    public String getPrice() {
        return price;
    }

    public String getAvailable() {
        return available;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCount() {
        return count;
    }

    public String isAvailable() {
        return available;
    }

    public List<CommentItem> getCommentItems() {
        return commentItems;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MenuItem)
            return (((MenuItem) obj).name.equals(this.name));
        return false;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setID(String id) {
        this.id = id;
    }
}
