package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


//        StreamAPIQuestions.findTheCountOfStudentsInEachDepartment();
//        StreamAPIQuestions.findAllDepartmentNames();
//        StreamAPIQuestions.findAgeLessThan25();
//                StreamAPIQuestions.findMaxAge();
//        StreamAPIQuestions.findAvgAgeOfMaleAndFemale();
//                StreamAPIQuestions.findcountOfStudentInEachDepartment();
//        StreamAPIQuestions.findYougestStudent();
//                StreamAPIQuestions.getSeniorStudent();
//        StreamAPIQuestions.findRankBetween50to100();
//                StreamAPIQuestions.findTheMaxcountStudentsIndepartment();
//                StreamAPIQuestions.findTheEmployeeWhoLeavesInMumbaiAndSortBytheriNames();
//        StreamAPIQuestions.noOfStudentPresentInCollege();
//        StreamAPIQuestions. findTheDepartmentHavingMaxStudent();
//        StreamAPIQuestions.findTheAverageRankInAllDepartments();
//        StreamAPIQuestions. findHighRankInEachDepartment();
//        StreamAPIQuestions.sortTheStudentsBasedonRank();
//        StreamAPIQuestions.findTheSecondHighestRank();
//        StreamAPIQuestions.displayRanksInEachDepartmentInDecendingOrder();

//            String value =" i am nalin";
//        Map<Character,Long> result = value.chars().mapToObj(c->(char)c).filter(t->t!= ' ')
//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//
//        System.out.println(result);
//
//
//        for(Map.Entry<Character,Long> vv:result.entrySet())
//        {
//            if(vv.getValue()>1)
//            {
//                System.out.println(vv.getKey());
//            }
//        }
            StreamAPIQuestions.findEmployeesWithagesgreaterthan26AndLessthan26();

        StreamAPIQuestions.groupByDepartmentThenByAge();


        // Group Words by Length and Sort Them

        List<String> words = Arrays.asList("java", "stream", "api", "example", "code", "test");
        Map<Integer,List<String>> groupwordsandsort = words.stream()
                .collect(Collectors.groupingBy(String::length,Collectors.collectingAndThen(Collectors.toList(),
                        list->list.stream().sorted().toList())));

        System.out.println(groupwordsandsort);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
            Map<Boolean,List<Integer>> paritioned = numbers.stream().collect(Collectors.partitioningBy(n->n % 2 ==0));
            List<Integer> evennumbers = paritioned.get(true);
            List<Integer> oddnumbers = paritioned.get(false);
        System.out.println(evennumbers);
        System.out.println(oddnumbers);


        //non repeating characters
        String ss = "swiss";
        System.out.println(ss.chars().mapToObj(s->(char)s)
                .filter(c->ss.chars()
                        .filter(ch->ch==c)
                        .count()==1).toList());

        ss.chars().mapToObj(s->(char)s).filter(c->ss.chars().filter(nn->nn==c).count()==1).toList();

        //find duplicates
        List<Integer> numberstofindduplicates = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6);

        numberstofindduplicates.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() > 1)
                .forEach(n-> System.out.print(n.getKey()+" "));

        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);
        System.out.println();
        System.out.println(map.entrySet().stream().map(entry->entry.getKey()+"="+entry.getValue()).sorted().toList());


        //check if list is sorted

        List<Integer> numberssortedornot = Arrays.asList(1, 2, 3,4,5);
        boolean sortedf = IntStream.range(0,numberssortedornot.size()-1)
                .allMatch(v->numberssortedornot.get(v)<=numberssortedornot.get(v+1));

        System.out.println(sortedf);

//        Arrays.stream(value.split(" "))
//                .filter(ch->!ch.equals(" "))
//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


        Stream<Integer> stream = Stream.of(2,17,5,20,17,30,4,23,59,23);
        Set<Integer> valueset = new HashSet<>();
        System.out.println(stream.filter(integer -> !valueset.add(integer)).collect(Collectors.toSet()));


        //reverse elements in a parallel stream

        List<Integer> parallelstreamelements = Arrays.asList(217,317,417,517);

        parallelstreamelements.parallelStream().collect(Collectors.collectingAndThen(Collectors.toList(),list->{
            Collections.reverse(list);
            return list.stream();
        })).forEach(s->System.out.print(s));



    }
    }
