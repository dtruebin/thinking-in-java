package chapter2_object;

import java.lang.reflect.Field;

class E05_DataOnly {
    public static void main(String[] args) throws IllegalAccessException {
        DataOnly dataOnly = new DataOnly();
        dataOnly.i = 1;
        dataOnly.d = 2.5d;
        dataOnly.b = true;

        for (Field field :
                dataOnly.getClass().getDeclaredFields()) {
            String name = field.getName();
            Object value = field.get(dataOnly);
            System.out.printf("%s: %s%n", name, value);
        }
    }
}

class DataOnly {
    int i;
    double d;
    boolean b;
}