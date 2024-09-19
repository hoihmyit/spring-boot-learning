package com.spl.hm;

public class Client {
    public static void main(String[] args) {
        Bank tpBank = BankFactory.getBank(BankType.TPBANK);
        System.out.println(tpBank.getBankName()); // TPBank

        Bank vietcomBank = BankFactory.getBank(BankType.VIETCOMBANK);
        System.out.println(vietcomBank.getBankName()); // VietcomBank
    }
}
