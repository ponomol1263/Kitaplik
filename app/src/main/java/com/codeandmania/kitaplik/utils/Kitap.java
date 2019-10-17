package com.codeandmania.kitaplik.utils;

public class Kitap {
    private int id;
    private String title;
    private String img;

    public Kitap(int id, String title, String img) {
        this.id = id;
        this.title = title;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
