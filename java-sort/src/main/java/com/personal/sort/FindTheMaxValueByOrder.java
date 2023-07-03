package com.personal.sort;

import java.util.*;

public class FindTheMaxValueByOrder {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 4, 5, 2, 5, 6, 4, 6, 1, 2, 4);
        Stack intStack = new Stack<>();
    }

    public static void sortWithComparator(List<Integer> ints){
        Collections.sort(ints, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println(ints);
    }
    public static void sortUsingLamda(List<Integer> ints){
        ints.sort((int1, int2) -> int1.compareTo(int2));
        System.out.println(ints);
    }
    public static void sortUsingLamdaAndMethodReference(List<Integer> ints){
        ints.sort(Integer::compareTo);
    }

    public static void sortWithComparing(List<Integer> integers){
        integers.stream().sorted().iterator().forEachRemaining(System.out::println);
    }
    public static void sortWithReverseOrder(List<Integer> integers){
        integers.stream().sorted(Comparator.reverseOrder()).iterator().forEachRemaining(System.out::println);
    }

}
