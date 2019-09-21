package com.duykhanh.intrologin.model;

import java.io.Serializable;

public class Course implements Serializable {
    private String title;
    private String description;
    private int idImage;

    public Course(String title, String description, int idImage){
        this.title = title;
        this.description = description;
        this.idImage = idImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
