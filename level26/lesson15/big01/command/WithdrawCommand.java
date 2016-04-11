package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class WithdrawCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String amount = "";
//        System.out.println("Please, enter the amount to withdraw.");
//        while (!(amount = ConsoleHelper.readString()).matches("^\\d+$")) {
//            System.out.println("Amount can only have digits. Try again.");
//        }
        do {
            System.out.println("Please, enter the amount to withdraw.");
            amount = ConsoleHelper.readString();
            if (!amount.matches("^\\d+$")) {
                System.out.println("Amount can only have digits. Try again.");
                continue;
            }
            if (!manipulator.isAmountAvailable(Integer.valueOf(amount))) {
                continue;
            }

            //TODO
            break;
        } while (true);
    }
}
