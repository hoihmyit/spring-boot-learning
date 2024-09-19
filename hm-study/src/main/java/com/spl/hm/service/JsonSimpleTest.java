package com.spl.hm.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class JsonSimpleTest {
    public static void main(String[] args) {

        // Write JSON to File
        JsonSimpleWriteExample();

        // Read JSON to File
        JsonSimpleReadExample();
    }

    private static void JsonSimpleReadExample() {
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("/Users/hmy/Documents/hoihmy/test.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
                //OUTPUT:
                //{"name":"Json Simple","messages":["msg 1","msg 2","msg 3"],"age":100}
                //Json Simple
                //100
                //msg 1
                //msg 2
                //msg 3
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void JsonSimpleWriteExample() {
        JSONObject obj = new JSONObject();
        obj.put("name", "Json Simple");
        obj.put("age", 100);

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        try (FileWriter file = new FileWriter("/Users/hmy/Documents/hoihmy/test.json")) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);
        // OUTPUT: {"name":"Json Simple","messages":["msg 1","msg 2","msg 3"],"age":100}
        // create a new file into /Users/hmy/Documents/hoihmy/test.json
    }
}
