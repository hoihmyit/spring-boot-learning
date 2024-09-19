package com.spl.hm.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spl.hm.model.Book;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JacksonTest {
    public static void main(String[] args) {

        convertObjectToJson();

        convertJsonToObject();

        convertJsonToArray();

        convertJsonToCollection();
    }

    public static Book getMyBook() {
        String[] tags = new String[]{"X", "Y", "Z"};
        List<String> authors = Arrays.asList("Mr.A", "Mrs.B", "Mr.C", "Mrs.D");
        Book myBook = new Book("My Book", 99.000, tags, authors, "description");
        return myBook;
    }

    private static void convertObjectToJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(getMyBook());
            System.out.println(json);
            //OUTPUT:
            //{"title":"My Book","price":99.0,"tags":["X","Y","Z"],"authors":["Mr.A","Mrs.B","Mr.C","Mrs.D"],"description":"description"}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertJsonToObject() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(getMyBook());

            Book book = mapper.readValue(json, Book.class);
            System.out.println(book);
            //OUTPUT:
            //Book{title='My Book', price=99.0, tags=[X, Y, Z], authors=[Mr.A, Mrs.B, Mr.C, Mrs.D], description='description'}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertJsonToArray() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(getMyBook().getTags());

            String[] tags = mapper.readValue(json, String[].class);
            System.out.println(Arrays.toString(tags));
            //OUTPUT:
            //[X, Y, Z]
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertJsonToCollection() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(getMyBook().getAuthors());

            List<String> authors = mapper.readValue(json, new TypeReference<>() {
            });
            System.out.println(Arrays.toString(authors.toArray()));
            //OUTPUT:
            //[Mr.A, Mrs.B, Mr.C, Mrs.D]
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
