package icu.trub.tij.chapter9_interfaces.interfaceprocessor;

public interface Processor {
    String name();

    Object process(Object input);
}
