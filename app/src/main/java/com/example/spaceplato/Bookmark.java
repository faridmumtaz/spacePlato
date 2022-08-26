package com.example.spaceplato;

public class Bookmark {
    String name;
    String image_id;
    String id;

    public Bookmark(String name, String image_id, String id) {
        this.name = name;
        this.image_id = image_id;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getImage_id() {
        return image_id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
