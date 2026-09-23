package org.example;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIQuestions {

	static List<Student> list = Arrays.asList(
			new Student(1, "Aditya", "Mall", 30, "Male", "Mechanical Engineering", 2014, "Mumbai", 122),
			new Student(2, "Pulkith", "Singh", 26, "Male", "Computer Engineering", 2018, "Delhi", 67),
			new Student(3, "Ankita", "Patil", 25, "Female", "Computer Engineering", 2019, "Kerala", 164),
			new Student(4, "Satish", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
			new Student(5, "Darshan", "Mukd", 23, "Male", "Instrumentation Engineering", 2022, "Mumbai", 12),
			new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
			new Student(7, "Appu", "Raj", 31, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
			new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
			new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
			new Student(10, "Satyam", "Pandey", 26, "Male", "Biotech Engineering", 2017, "Mumbai", 98));

	public static void findTheCountOfStudentsInEachDepartment() {
//		Map<String, Long> collect = list.stream()
//				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
//		System.out.println("Count of Students in each Department" + collect);

        Map<String,Long> collect = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()));
        System.out.println("COunt of students in each dept"+collect);
	}

    public static void findEmployeesWithagesgreaterthan26AndLessthan26()
    {
        //System.out.println( list.stream().filter(student -> student.getAge() != 26).toList());

        LinkedHashMap<String,Integer> collectnameandage = list.stream().filter(s->s.getAge()!=26)
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .collect(Collectors.toMap(Student::getFirstName,Student::getAge,
                        (oldvalue,newvalue)->oldvalue,LinkedHashMap::new));

        System.out.println(collectnameandage);
    }

    public static void groupByDepartmentThenByAge()
    {
        Map<String,Map<Integer,List<String>>> grouped = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName,
                        Collectors.groupingBy(Student::getAge,
                                Collectors.mapping(Student::getFirstName,Collectors.toList()))));

        System.out.println(grouped);
    }
	public static void findAllDepartmentNames() {

		List<String> deptName = list.stream()
                .map(Student::getDepartmantName).distinct().toList();

		System.out.println("Deaprtment Names " + deptName);

	}

	public static void findAgeLessThan25() {

		List<Student> collect = list.stream().filter(t -> t.getAge() < 25).toList();


		System.out.println("List of Students whose Age is leass than 25 " + collect);

	}

	public static void findMaxAge() {

		OptionalInt max = list.stream().mapToInt(t -> t.getAge()).max();
        System.out.println("Max age of students " + max.getAsInt());

	}

	public static void findAvgAgeOfMaleAndFemale() {

		Map<String, Double> collect = list.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));

        Map<String,Double> avgagesmaleandfemale  = list.stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge)));

        Map<String,Double> avgages = list.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge)));
		System.out.println("Average age of Male and Female students " + collect);

	}

	public static void findcountOfStudentInEachDepartment() {

		Map<String, Long> collect = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
		System.out.println(collect);

	}

	public static void findYougestStudent() {

		int min = list.stream().mapToInt(Student::getAge).min().getAsInt();

		System.out.println("Minimum age of student is " + min);

		// or

		Student student = list.stream().min(Comparator.comparing(Student::getAge)).get();
		System.out.println("Young student is " + student);

	}

	public static void getSeniorStudent() {

		int seniorStudent = list.stream()
                .filter(t -> t.getGender().equals("Female"))
                .mapToInt(Student::getAge).max()
				.getAsInt();

		System.out.println("Senior Female student is " + seniorStudent);

		Student student = list.stream()
                .filter(t -> t.getGender().equals("Female"))
				.max(Comparator.comparing(Student::getAge)).get();

		System.out.println("Senior Female student is " + student);

	}

	public static void findRankBetween50to100() {

		List<Student> collect = list.stream()
                .filter(t -> t.getRank() > 50 && t.getRank() < 100)
				.collect(Collectors.toList());
		System.out.println(collect);

	}

	public static void findTheMaxcountStudentsIndepartment() {

		Entry<String, Long> entry = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                .entrySet().stream()
				.max(Entry.comparingByValue()).get();


		System.out.println(entry);

	}

	public static void findTheEmployeeWhoLeavesInMumbaiAndSortBytheriNames() {

//		List<Student> collect = list.stream().filter(t -> t.getCity().equals("Mumbai"))
//				.sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
//		System.out.println(collect);
        List<Student> collect = list.stream().filter(t->t.getCity().equals("Mumbai"))
                .sorted(Comparator.comparing(Student::getFirstName))
                .toList();

        System.out.println(collect);
	}

	public static void noOfStudentPresentInCollege() {

		long count = list.size();
		System.out.println(count);

	}

	public static void findTheDepartmentHavingMaxStudent() {

		Entry<String, Long> entry = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).entrySet().stream()
				.max(Entry.comparingByValue()).get();

		System.out.println(entry.getKey() + " " + entry.getValue());

	}

	public static void findTheAverageRankInAllDepartments() {

		Map<String, Double> collect = list.stream()
				.collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
        System.out.println(collect);

	}

	public static void findHighRankInEachDepartment() {

		Map<String, Optional<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,
				Collectors.minBy(Comparator.comparing(Student::getRank))));

		System.out.println(collect);

	}

	public static void sortTheStudentsBasedonRank() {
		List<Student> collect = list.stream().sorted(Comparator.comparing(Student::getRank))
				.collect(Collectors.toList());

		System.out.println(collect);
	}

	public static void findTheSecondHighestRank() {

		Student student = list.stream().sorted(Comparator.comparing(Student::getRank))
                .skip(1).findFirst().get();

		System.out.println(student);

	}

	public static void displayRanksInEachDepartmentInDecendingOrder() {

//		Map<String, List<Student>> collect = list.stream()
//				.collect(Collectors.groupingBy(Student::getDepartmantName,
//						Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
//								.sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList()))));
//		System.out.println(collect);


        Map<String,List<Student>> collect = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName,
                Collectors.collectingAndThen(Collectors.toList(),list->list.stream()
                        .sorted(Comparator.comparing(Student::getRank)).toList())));

        System.out.println(collect);
	}

	 

}
