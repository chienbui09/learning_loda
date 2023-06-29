package com.personal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Employee> employees = Arrays.asList(
                new Employee("George", 10, 10000),
                new Employee("Robert", 12, 15000),
                new Employee("Kathy", 24, 25000)
        );
    }

    public static void multiSort(List<Employee> employees){
        employees.sort(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getAge));
    }

    public static void sortByNameAndAge(List<Employee> employees){
        employees.sort(sortByName.thenComparing(sortByAge));
    }
    static Comparator<Employee> sortByName = (e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName());
    static Comparator<Employee> sortByAge = Comparator.comparingInt(Employee::getAge);




}