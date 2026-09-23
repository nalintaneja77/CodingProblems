package org.example;

public class ParentChild {
    public static void main(String[] args) {

        Parent p = new Child();
        p.parentMethod();
        p.parentMethod1();
        //((Child)p).childMethod();

    }
}
