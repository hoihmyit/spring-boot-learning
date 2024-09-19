package com.spl.hm.virtualproxy;

public class Client {
    public static void main(String[] args) {
        System.out.println("Init proxy image: ");
        ProxyImage proxyImage = new ProxyImage("https://test.com/favicon.ico");

        System.out.println("---");
        System.out.println("Call real service 1st: ");
        proxyImage.showImage();

        System.out.println("---");
        System.out.println("Call real service 2nd: ");
        proxyImage.showImage();

        // Output
        //Init proxy image:
        //Image unloaded: https://test.com/favicon.ico
        //---
        //Call real service 1st:
        //Image loaded: https://test.com/favicon.ico
        //Image showed: https://test.com/favicon.ico
        //---
        //Call real service 2nd:
        //Image already existed: https://test.com/favicon.ico
        //Image showed: https://test.com/favicon.ico
    }
}
