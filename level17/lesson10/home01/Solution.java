package com.javarush.test.level17.lesson10.home01;

import java.util.*;

/* Общий список
1. Изменить класс Solution так, чтобы он стал списком. (Необходимо реализовать интерфейс java.util.List).
2. Список Solution должен работать только с целыми числами Long.
3. Воспользуйтесь полем original.
4. Список будет использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
*/

public class Solution implements List<Long> {
    private static ArrayList<Long> original = new ArrayList<Long>();

    public synchronized int size()
    {
        return original.size();
    }

    public synchronized boolean isEmpty()
    {
        return original.isEmpty();
    }

    public synchronized boolean contains(Object o)
    {
        return original.contains(o);
    }

    public synchronized Iterator iterator()
    {
        return original.iterator();
    }

    public synchronized Object[] toArray()
    {
        return original.toArray();
    }

    public synchronized boolean add(Long aLong)
    {
        return original.add(aLong);
    }


    public synchronized boolean remove(Object o)
    {
        return original.remove(o);
    }

    public synchronized boolean addAll(Collection c)
    {
        return original.addAll(c);
    }

    public synchronized boolean addAll(int index, Collection c)
    {
        return original.addAll(index, c);
    }

    public synchronized void clear()
    {
        original.clear();
    }

    public synchronized Long get(int index)
    {
        return original.get(index);
    }

    public synchronized Long set(int index, Long element)
    {
        return original.set(index, element);
    }

    public synchronized void add(int index, Long element)
    {
        original.add(index, element);
    }

    public synchronized Long remove(int index)
    {
        return original.remove(index);
    }

    public synchronized int indexOf(Object o)
    {
        return original.indexOf(o);
    }

    public synchronized int lastIndexOf(Object o)
    {
        return original.lastIndexOf(o);
    }

    public synchronized ListIterator<Long> listIterator()
    {
        return original.listIterator();
    }

    public synchronized ListIterator<Long> listIterator(int index)
    {
        return original.listIterator(index);
    }

    public synchronized List<Long> subList(int fromIndex, int toIndex)
    {
        return original.subList(fromIndex, toIndex);
    }

    public synchronized boolean retainAll(Collection c)
    {
        return original.retainAll(c);
    }

    public synchronized boolean removeAll(Collection c)
    {
        return original.removeAll(c);
    }

    public synchronized boolean containsAll(Collection c)
    {
        return original.containsAll(c);
    }

    public synchronized <T> T[] toArray(T[] a)
    {
        return original.toArray(a);
    }
}
