package chapter11_holding;

/*
Create a class, then make an initialized array of objects of your class. Fill
a List from your array. Create a subset of your List by using subList( ), then
remove this subset from your List.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Phone {
    float screenSize;

    Phone(float screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "screenSize=" + screenSize +
                '}';
    }
}

public class E07_ListFromArray {
    public static void main(String[] args) {
        Phone[] phones = {new Phone(4), new Phone(5), new Phone(5.5f), new Phone(7)};
        List<Phone> phoneList = new ArrayList<>(Arrays.asList(phones));
        List<Phone> phoneList5 = phoneList.subList(1, 3);
        phoneList.removeAll(phoneList5);
        System.out.println(phoneList);
    }
}