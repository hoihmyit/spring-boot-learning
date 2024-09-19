package com.spl.hm;

import org.springframework.stereotype.Component;

@Component
public class BankFactory {

    public BankFactory() {
    }

    public static final Bank getBank(BankType bankType) {
        switch (bankType) {
            case TPBANK:
                return new TPBank();
            case VIETCOMBANK:
                return new VietcomBank();
            default:
                throw new IllegalArgumentException("This bank type is unsupported!");
        }
    }
}
