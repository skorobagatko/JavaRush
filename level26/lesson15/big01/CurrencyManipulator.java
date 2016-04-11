package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    String currencyCode;
    Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = new HashMap<Integer, Integer>();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            int newCount = count + denominations.get(denomination);
            denominations.put(denomination, newCount);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int result = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            result += (pair.getKey() * pair.getValue());
        }
        return result;
    }

    public boolean hasMoney() {
        return !denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount < getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        // TODO
        return result;
    }
}
