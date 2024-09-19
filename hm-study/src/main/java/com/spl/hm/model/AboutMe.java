package com.spl.hm.model;

import java.util.List;

public class AboutMe {
    private String name;
    private String title;
    private String address;
    private List<String> hobbies;

    public AboutMe() {
    }

    public AboutMe(String name, String title, String address, List<String> hobbies) {
        this.name = name;
        this.title = title;
        this.address = address;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "AboutMe{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
