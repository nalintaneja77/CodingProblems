package org.example;



public class alonefunctionalinterface {

    public static void main(String[] args) {

      //  Printer printer = message -> System.out.println("Hello"+message);
        Printer printer =  new Printer() {
            @Override
            public void print(String message) {
                System.out.println("Hello print" + message);
            }

            @Override
            public String printplace(String message) {
               return "Default method called from interface"+message;
            }
        };

       printer.print("Test");
        System.out.println(printer.printplace("hello"));
        System.out.println(Printer.printstatic("new message"));

        Calculator calculator = (a, b) -> a+b;
        System.out.println(calculator.add(3,4));

    }
}
