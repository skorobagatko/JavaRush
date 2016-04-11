package com.javarush.test.level26.lesson15.big01;

import java.util.*;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> manipulators = new HashMap<String, CurrencyManipulator>();

    private CurrencyManipulatorFactory() {

    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (manipulators.containsKey(currencyCode)) {
            return manipulators.get(currencyCode);
        }
        CurrencyManipulator newManipulator = new CurrencyManipulator(currencyCode);
        manipulators.put(currencyCode, newManipulator);
        return newManipulator;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return manipulators.values();
    }

//    public static boolean hasMoney() {
//        return !manipulators.isEmpty();
//    }
}
