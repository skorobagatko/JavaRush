package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {

    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }

        public A() {}
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
            is.defaultReadObject();
            this.name = (String) is.readObject();
        }

        private void writeObject(ObjectOutputStream os) throws IOException {
            os.defaultWriteObject();
            os.writeObject(this.name);

            // По умолчанию, при десериализации, мы теряли значение поля name, т.к. при десериализации вызывается конструктор
            // родительского класса, и он перезаписывал значение поля name значением по умолчанию.
            // Т.е. нам нужно было явно сохранить значение поля name (отдельно от всего остального), чтобы восстановить его значение при десериализации.
        }
    }
}
