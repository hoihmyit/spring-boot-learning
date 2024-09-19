package com.spl.hm;

public class ClassSingleton {
    public static void main(String[] args) {
        System.out.println("--- Singleton Pattern ---");
        Singleton single1 = Singleton.getInstance();
        Singleton single2 = Singleton.getInstance();

        if (single1.equals(single2)) {
            System.out.println("Unique Instance");

        }
        //--- Singleton Pattern ---
        //Unique Instance
    }
}
