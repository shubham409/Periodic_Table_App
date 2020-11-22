package com.example.importdb2;

public class Word {
    private String name;
    private int resourceid;

    public Word(String name, int resourceid) {
        this.name = name;
        this.resourceid = resourceid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResourceid() {
        return resourceid;
    }

    public void setResourceid(int resourceid) {
        this.resourceid = resourceid;
    }
}
