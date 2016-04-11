package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class ExitCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        System.out.println("Do you really want EXIT? <y/n>");
        String s = ConsoleHelper.readString();
        if (s.equals("y")) System.out.println("Good bye!");
    }
}
