package org.example;

public class PatternMatching {
    public static void main(String[] args) {
        Object object = null;

//        if(object instanceof String s)
//        {
//            System.out.println(s.toUpperCase());
//        }
//        else if(object instanceof Integer i && i>20)
//        {
//            System.out.println(i*2);
//        }
//acted as a preview feature in java 17
        switch (object){
            case String s  -> System.out.println(s.toUpperCase());
            case Integer i -> System.out.println(i*2);
            case null -> System.out.println("Object is null");
            default -> {}
        }
    }
}
