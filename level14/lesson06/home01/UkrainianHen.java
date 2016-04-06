package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Stanislav on 30.11.2015.
 */
public class UkrainianHen extends Hen
{
    int getCountOfEggsPerMonth() {
        return 25;
    }

    String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
