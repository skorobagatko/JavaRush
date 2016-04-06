package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        List<Integer> denominatorA = new ArrayList<Integer>();
        List<Integer> denominatorB = new ArrayList<Integer>();

        if (a > 0 && b > 0) {

                for (int index = 2; index <= a; index++) {
                    if (a % index == 0) {
                        denominatorA.add(index);
                    }
                }


                for (int index = 2; index <= b; index++) {
                    if (b % index == 0) {
                        denominatorB.add(index);
                    }
                }
        }


        int nod = 1;

        for (Integer numberA : denominatorA) {

            for (Integer numberB : denominatorB) {
                if (numberA.equals(numberB) && numberA > nod) { nod = numberA; }
            }
        }

        System.out.println(nod);

    }
}
