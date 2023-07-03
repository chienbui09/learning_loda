package com.personal.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapPractise {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("Geeks", 10);
        map.put("4", 15);
        map.put("Geeks", 20);
        map.put("Welcomes", 25);
        map.put("You", 30);

        Optional<Map.Entry<String, Integer>> first = map.entrySet().stream().filter(entry -> "4".equalsIgnoreCase(entry.getKey())).findFirst();
    }
}
