package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class customerStream {
    public static void main(String[] args) {

        List<Customer> customers =  Arrays.asList(

                // Nalin - 3 transactions
                new Customer(101, "Nalin", 5000, "2026-08-10 10:30:00"),
                new Customer(101, "Nalin", 2500, "2026-08-10 12:15:00"),
                new Customer(101, "Nalin", 7500, "2026-08-10 15:45:00"),

                // Rohan - 3 transactions
                new Customer(102, "Rohan", 3000, "2026-08-10 09:20:00"),
                new Customer(102, "Rohan", 4500, "2026-08-10 11:30:00"),
                new Customer(102, "Rohan", 2000, "2026-08-10 16:10:00"),

                // Amit - 2 transactions
                new Customer(103, "Amit", 8000, "2026-08-10 10:00:00"),
                new Customer(103, "Amit", 3500, "2026-08-10 14:30:00"),

                // Priya - 3 transactions
                new Customer(104, "Priya", 1500, "2026-08-10 08:45:00"),
                new Customer(104, "Priya", 6000, "2026-08-10 13:15:00"),
                new Customer(104, "Priya", 2500, "2026-08-10 17:00:00"),

                // Neha - 2 transactions
                new Customer(105, "Neha", 9000, "2026-08-10 09:30:00"),
                new Customer(105, "Neha", 4000, "2026-08-10 18:00:00")
        );

        System.out.println(customers.stream().map(Customer::getCustomer).toList());

        System.out.println(customers.stream().mapToInt(Customer::getTransactionAmount));

        Map<String,Integer> findtotaltransactionamountspercustomer =
                customers.stream().collect(Collectors.groupingBy(Customer::getCustomer, Collectors.summingInt(Customer::getTransactionAmount)));

        System.out.println(findtotaltransactionamountspercustomer);

        Map<String,String> totals = findtotaltransactionamountspercustomer.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, stringIntegerEntry -> {
        if(stringIntegerEntry.getValue()>12000)
        {
            return "HIGH";
        }
        return "LOW";
        }));

       System.out.println(totals);



    }
}
