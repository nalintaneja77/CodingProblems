package org.example;

public class exceptiontest {

    static void test() throws Exception
    {
        throw new Exception();
    }

    public static void main (String[] args) throws Exception{
        try {

            exceptiontest.test();
        }
        finally {
            System.out.println("finally");
        }
    }
}
