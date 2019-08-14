package com.muhmdreza.foodorderingsystem.Models;


import java.util.HashMap;
import java.util.Map;

public class Order {
    private String id;
    private Map<MenuItem, Integer> menuItems;
    private String state;
    private String description;

    public void setId(String id) {
        this.id = id;
    }
    public Order() {
        this.menuItems = new HashMap<>();
    }

    public void addFood(MenuItem menuItem) {
        if (menuItems.containsKey(menuItem))
            menuItems.put(menuItem, menuItems.get(menuItem) + 1);
        else menuItems.put(menuItem, 1);
    }

    public void removeFood(MenuItem menuItem) {
        if (menuItems.containsKey(menuItem))
            if (menuItems.get(menuItem) >= 1)
                menuItems.put(menuItem, menuItems.get(menuItem) - 1);
        if (menuItems.get(menuItem) == 0) menuItems.remove(menuItem);
    }

    public Map<MenuItem, Integer> getMenuItems() {
        return menuItems;
    }

    public int getCount(MenuItem menuItem) {
        if (menuItems.containsKey(menuItem))
            return menuItems.get(menuItem);
        else return 0;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
