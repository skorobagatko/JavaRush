package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Stanislav on 10.12.2015.
 */
public class SubSolution extends Solution
{
    private SubSolution(float f) { super(f);}
    private SubSolution(String s) { super(s);}
    private SubSolution(int i) { super(i);}

    SubSolution(String s, String i)
    {
        super(s, i);
    }

    SubSolution(int i, int j)
    {
        super(i, j);
    }

    SubSolution(double d)
    {
        super(d);
    }

    protected SubSolution(double d, double t)
    {
        super(d, t);
    }

    protected SubSolution(float f, float t)
    {
        super(f, t);
    }

    protected SubSolution(Object o)
    {
        super(o);
    }

    public SubSolution(int[] array)
    {
        super(array);
    }

    public SubSolution(String[] array)
    {
        super(array);
    }

    public SubSolution(char[] ch)
    {
        super(ch);
    }
}
