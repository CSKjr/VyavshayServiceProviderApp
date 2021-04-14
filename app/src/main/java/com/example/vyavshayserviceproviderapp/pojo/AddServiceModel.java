package com.example.vyavshayserviceproviderapp.pojo;

public class AddServiceModel {
    private int itemImage;
    private String itemName;
    private int count;

    public AddServiceModel(int image, String name, int count) {
        this.itemImage = image;
        this.itemName = name;
        this.count = count;
    }

    public int getImages() {
        return itemImage;
    }

    public void setImages(int images) {
        this.itemImage = images;
    }

    public void setItemNames(String itemNames) {
        this.itemName = itemNames;
    }

    public String getItemNames() {
        return itemName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
