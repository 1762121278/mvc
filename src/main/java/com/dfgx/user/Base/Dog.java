package com.dfgx.user.Base;

import java.util.*;
import java.util.function.Function;

public class Dog {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"c","a","b","d");
        int a = Collections.binarySearch(list, "a");
        String max = Collections.max(list);
        System.out.println(max);
        System.out.println(list+" "+a);
        List<String> list2 = Collections.synchronizedList(list);
        System.out.println(list2);

        String ad = "abcdeedabb";
        List<String> list1 = Collections.singletonList(ad);
        HashSet<String> set = new HashSet<>(list1);
        System.out.println(set);

        HashMap<String, Object> hashmap = new HashMap<>();
        hashmap.put("1",2);
        hashmap.put("2",2);
        hashmap.put("3",2);
        hashmap.put("4",2);
        Set<String> hashset = hashmap.keySet();
        System.out.println(hashset);
        Set<Map.Entry<String, Object>> seta = hashmap.entrySet();
        System.out.println(seta);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0)-o1.charAt(0);
            }
        });
        System.out.println(list);
        String sd = "ada";
        char e = sd.charAt(0);
        System.out.println(e);
        int d = sd.indexOf("a");
        System.out.println(d);
    }
}
