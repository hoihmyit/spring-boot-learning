package com.spl.hm.model;

public class Booked {
    private int id;
    private String title;
    private String author;
    private String bookURL;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookURL() {
        return bookURL;
    }

    public void setBookURL(String bookURL) {
        this.bookURL = bookURL;
    }

    @Override
    public String toString() {
        return "Booked{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", bookURL='" + bookURL + '\'' +
                '}';
    }
}
