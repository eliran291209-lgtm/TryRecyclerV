package com.example.tryrecyclerv;

import java.util.ArrayList;

public class Item {
    private String name ;
    private String description ;
    private int image ;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }



    public Item(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

}
