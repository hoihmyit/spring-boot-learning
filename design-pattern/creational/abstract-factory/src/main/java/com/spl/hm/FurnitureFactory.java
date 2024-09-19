package com.spl.hm;

public class FurnitureFactory {

    public FurnitureFactory() {
    }

    public static FurnitureAbstractFactory getFactory(MaterialType type) {
        switch (type) {
            case PLASTIC:
                return new PlasticFactory();
            case WOOD:
                return new WoodFactory();
            default:
                throw new IllegalArgumentException("This furniture is unsupported!");
        }
    }
}
