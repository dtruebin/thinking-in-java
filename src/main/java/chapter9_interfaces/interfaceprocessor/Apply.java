package chapter9_interfaces.interfaceprocessor;

public class Apply {
    public static void process(Processor p, Object s) {
        {
            System.out.println("Using Processor " + p.name());
            System.out.println(p.process(s));
        }
    }

    public static void main(String[] args) {
        String str = "Quick brown Fox jumps over a lazy Dog.";
        process(new ChartSwapperAdapter(), str);
    }
}