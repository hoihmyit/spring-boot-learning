package com.spl.hm;

public class VietnameseClient {
    public static void main(String[] args) {
        VietnameseTarget client = new TranslatorAdapter(new JapaneseAdaptee());
        client.send("Xin chào");

        //OUTPUT:
        //Reading Words ...
        //Xin chào
        //Translated!
        //Sending Words ...
        //Retrieving words from Adapter ...
        //こんにちは
    }
}
