package org.example;

@FunctionalInterface
public interface Printer {

    void print(String message);

    default String printplace(String message)
    {
        return "printing from default method";
    }

    static String printstatic(String message)
    {
        return "printing from static method"+message;
    }
}
