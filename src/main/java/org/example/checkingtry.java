package org.example;

public class checkingtry {
        public static void main(String[] args) {
            System.out.println(testMethod());
        }

        static int testMethod() {
            try {
                return 1;
            } finally {
                return 2;
            }
        }
    }


