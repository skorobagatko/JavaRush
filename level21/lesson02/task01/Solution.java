package com.javarush.test.level21.lesson02.task01;

/* Определяем адрес сети
1) Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).
Пример:
IP-адрес:       11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети:  11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) Реализовать метод print, который выведет в консоль данные в двоичном коде
3) Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[ip.length];
        for (int i = 0; i < netAddress.length; i++) {
            netAddress[i] = (byte) (ip[i] & mask[i]);
        }

        return netAddress;
    }

    public static void print(byte[] bytes) {
        for (byte aByte : bytes) {
            String s = String.format("%8s", Integer.toBinaryString(aByte & 0xFF));
            // Если наши 8 бит начинаются с нуля (слева), то эти нули отбрасываются и в итоге мы получаем не правильное число
            // %8s - строковое представление аргумента, т.е. нашего числа. Здесь цифра 8 - спецификатор точности, который задает кол-во выводимых знаков
            // 0xFF - маска для отделения младших 8 бит, которые нам нужны от остальных бит, которые были заполнены автоматически
            s = s.replace(' ', '0');  // в этой строке мы заполняем наш байт нулями, которые были отброшены при конвертации из числа в битовую строку
            System.out.print(s + " ");
        }
        System.out.println("\n");
    }
}
