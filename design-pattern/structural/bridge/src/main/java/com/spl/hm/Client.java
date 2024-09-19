package com.spl.hm;

public class Client {
    public static void main(String[] args) {
        Bank vietcomBank = new VietcomBank(new CheckingAccount());
        vietcomBank.openAccount();

        Bank tpBank = new TPBank(new CheckingAccount());
        tpBank.openAccount();

        //OUTPUT:
        //Open your account at VietcomBank is a Checking Account
        //Open your account at TPBank is a Checking Account
    }
}
