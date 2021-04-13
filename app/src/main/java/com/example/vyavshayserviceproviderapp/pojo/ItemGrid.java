package com.example.vyavshayserviceproviderapp.pojo;

public class ItemGrid {
    String birdListName;
    int birdListImage;

    public ItemGrid(String birdName,int birdImage)
    {
        this.birdListImage=birdImage;
        this.birdListName=birdName;
    }

    public String getBirdListName() {
        return birdListName;
    }

    public void setBirdListName(String birdListName) {
        this.birdListName = birdListName;
    }

    public int getBirdListImage() {
        return birdListImage;
    }

    public void setBirdListImage(int birdListImage) {
        this.birdListImage = birdListImage;
    }
}
