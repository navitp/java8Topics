package com.java.eight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachTest {

    public static void main (String[] args) {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        //iterateMapOldWay(items);
        //iterateMapLambdaWay(items);

        //List
        List<String> itemList = new ArrayList<>();
        itemList.add("A");
        itemList.add("B");
        itemList.add("C");
        itemList.add("D");
        itemList.add("E");

        iterateListLambdaWay(itemList);

    }

    private static void iterateMapOldWay(Map<String, Integer> items) {
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("OldWay Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
    }

    private static void iterateMapLambdaWay(Map<String, Integer> items) {
        items.forEach((k,v)->System.out.println("Lambda Item : " + k + " Count : " + v));

        items.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            if("E".equals(k)){
                System.out.println("Hello E");
            }
        });
    }

    private static void iterateListLambdaWay(List<String> items) {
        //lambda
        //Output : A,B,C,D,E
        items.forEach(item->System.out.println(item));

        //Output : C
        items.forEach(item->{
            if("C".equals(item)){
                System.out.println(item);
            }
        });

        //method reference
        //Output : A,B,C,D,E
        items.forEach(System.out::println);


        //Stream and filter
        //Output : B
        items.stream()
                .filter(s->s.contains("B"))
                .forEach(System.out::println);
    }
}
