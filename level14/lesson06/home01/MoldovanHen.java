package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Stanislav on 30.11.2015.
 */
public class MoldovanHen extends Hen
{
    int getCountOfEggsPerMonth() {
        return 20;
    }

    String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
