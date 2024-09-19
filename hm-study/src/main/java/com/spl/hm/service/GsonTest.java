package com.spl.hm.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spl.hm.model.Book;

import java.util.Arrays;
import java.util.List;

public class GsonTest {
    public static void main(String[] args) {

        convertObjectToJson();

        convertJsonToObject();

        convertJsonToArray();

        convertJsonToCollection();
    }

    private static void convertJsonToCollection() {
        Gson gson = new Gson();
        String json = gson.toJson(getLienQuanBook().getAuthors());

        List<String> authors = gson.fromJson(json, new TypeToken<List<String>>() {
        }.getType());
        System.out.println(Arrays.toString(authors.toArray()));
        // OUTPUT:
        //[Mr.John, Mrs.Violet, Mr.Richter, Mr.Paine]
    }

    private static void convertJsonToArray() {
        Gson gson = new Gson();
        String json = gson.toJson(getLienQuanBook().getTags());

        String[] tags = gson.fromJson(json, String[].class);
        System.out.println(Arrays.toString(tags));
        // OUTPUT:
        //[AAA, BBB, CCC, DDD]
    }

    private static void convertJsonToObject() {
        Gson gson = new Gson();
        String json = gson.toJson(getLienQuanBook());

        Book book = gson.fromJson(json, Book.class);
        System.out.println(book);
        // OUTPUT:
        //Book(title=Lien Quan Book, price=96.69, tags=[AAA, BBB, CCC, DDD], authors=[Mr.John, Mrs.Violet, Mr.Richter, Mr.Paine], description=description)
    }

    private static void convertObjectToJson() {
        Gson gson = new Gson();
        String json = gson.toJson(getLienQuanBook());
        System.out.println(json);
        // OUTPUT:
        // {"title":"Lien Quan Book","price":96.69,"tags":["AAA","BBB","CCC","DDD"],"authors":["Mr.John","Mrs.Violet","Mr.Richter","Mr.Paine"],"description":"description"}
    }

    public static Book getLienQuanBook() {
        String[] tags = new String[]{"AAA", "BBB", "CCC", "DDD"};
        List<String> authors = Arrays.asList("Mr.John", "Mrs.Violet", "Mr.Richter", "Mr.Paine");
        Book lienQuanBook = new Book("Lien Quan Book", 96.69, tags, authors, "description");
        return lienQuanBook;
    }
}
