package com.spl.hm.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hoihmy on 12/11/20.
 */
public class Book {
    private String title;
    private double price;
    private String[] tags;
    private List<String> authors;
    private String description;

    public Book() {
    }

    public Book(String title, double price, String[] tags, List<String> authors, String description) {
        this.title = title;
        this.price = price;
        this.tags = tags;
        this.authors = authors;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", tags=" + Arrays.toString(tags) +
                ", authors=" + authors +
                ", description='" + description + '\'' +
                '}';
    }
}
