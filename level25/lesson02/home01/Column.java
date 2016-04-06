package com.javarush.test.level25.lesson02.home01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new ArrayList<>();
        /**
         *  Считаем кол-во видимых колонок
         */
        int columnsCount = 0;
        for (int i : realOrder) {
            if (i != -1) columnsCount++;
        }
        /**
         *  Счетчик count нужен для введения состояния окончания внешнего цикла
         *  Переменная index введена для поиска колонок в массиве realOrder
         *  начиная с нулевого значения.
         *  Значения указанные в ячейках массива realOrder обозначают последовательность
         *  в которой необходимо добавлять колонки в result. При этом, индексы массива
         *  realOrder обозначают какую-именно колонку из перечисления необходимо взять
         *  для добваления (индекс массива = номер колонки в перечислении)
         */
        int count = 0;
        int index = 0;
        while (count < columnsCount) {
            for (int i = 0; i < realOrder.length; i++) {
                if (realOrder[i] == index) {
                    for (Column column : values()) {
                        if (column.ordinal() == i) {
                            result.add(column);
                            count++;
                        }
                    }
                }
            }
            index++;
        }
        return result;
    }


    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
        return realOrder[this.ordinal()] != -1;
    }

    @Override
    public void hide() {
        if (this.isShown()) {
            realOrder[this.ordinal()] = -1;
        }
    }
}
