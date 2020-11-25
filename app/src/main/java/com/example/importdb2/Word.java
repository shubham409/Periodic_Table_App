package com.example.importdb2;

//public class Word {

//    private String name;
//    private int resourceid;
//
//    public Word(String name, int resourceid) {
//        this.name = name;
//        this.resourceid = resourceid;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getResourceid() {
//        return resourceid;
//    }
//
//    public void setResourceid(int resourceid) {
//        this.resourceid = resourceid;
//    }
//}

public class Word {

    private String name;
    private String symbol;
    private String property;
    private String group;
    private String nature;

    public Word(String name, String symbol, String property, String group, String nature) {
        this.name = name;
        this.symbol = symbol;
        this.property = property;
        this.group = group;
        this.nature = nature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
}
