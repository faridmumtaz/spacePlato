package com.example.spaceplato;

public class BookmarkModel {
    public String name;
    public String image_id;
    public String id;

    public BookmarkModel(String name, String image_id, String id) {
        this.name = name;
        this.image_id = image_id;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image_id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image_id) {
        this.image_id = image_id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
