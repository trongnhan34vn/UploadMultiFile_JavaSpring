package com.example.md4_ss15_baith3_uploadfile.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ProductForm {
    private int id;

    private String name;

    private String description;

    private List<MultipartFile> image;

    public ProductForm() {
    }

    public ProductForm(int id, String name, String description, List<MultipartFile> image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MultipartFile> getImage() {
        return image;
    }

    public void setImage(List<MultipartFile> image) {
        this.image = image;
    }
}
