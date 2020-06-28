package chapter5_initialization;

public class E19_VarArgsStringArray {
    static void printStrings(String... strings) {
        for (String string :
                strings) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        printStrings("one", "two", "three");
        printStrings("abc", "def", "ghi");
    }
}
