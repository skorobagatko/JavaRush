package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;

class InfoCommand implements Command {

    @Override
    public void execute() {
        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();

        for (CurrencyManipulator manipulator : manipulators) {
            if (!manipulator.hasMoney()) {
                System.out.println("No money available.");
            } else {
                System.out.println(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }
    }
}
