package main.java.chapter9_interfaces.interfaceprocessor;

public class ChartSwapperAdapter implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return CharSwapper.swap((String) input);
    }
}
