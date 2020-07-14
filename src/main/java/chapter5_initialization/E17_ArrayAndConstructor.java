package main.java.chapter5_initialization;

import java.util.Random;

/**
 * 17) Создайте класс с конструктором, получающим аргумент String. Выведите
 * значение аргумента во время конструирования. Создайте массив ссылок на этот
 * класс, но не создавайте объекты, которыми заполняется массив. Запустите
 * программу и посмотрите, будут ли выводиться сообщения при вызове
 * конструкторов.
 * <p>
 * 18) Завершите предыдущее упражнение — создайте объекты, которыми заполняется
 * массив ссылок.
 */
public class E17_ArrayAndConstructor {
    E17_ArrayAndConstructor(String s) {
        System.out.println("Running constructor with s = " + s);
    }

    public static void main(String[] args) {
        Random rnd = new Random();

        // 17
        @SuppressWarnings("MismatchedReadAndWriteOfArray")
        E17_ArrayAndConstructor[] arr = new E17_ArrayAndConstructor[5];

        // 18
        for (E17_ArrayAndConstructor item :
                arr) {
            //noinspection UnusedAssignment
            item = new E17_ArrayAndConstructor(rnd.nextInt() + "");
        }
    }
}
