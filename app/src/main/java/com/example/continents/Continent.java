package com.example.continents;

public class Continent {
    private String name;
    private int shapeImg;

    public Continent(String name, int shapeImg) {
        this.name = name;
        this.shapeImg = shapeImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShapeImg() {
        return shapeImg;
    }

    public void setShapeImg(int shapeImg) {
        this.shapeImg = shapeImg;
    }
}

