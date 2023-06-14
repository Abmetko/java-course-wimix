package com.javc.collections.examples;

import java.util.*;

public class ArrayListExercises {

    public static void findThreeMaxValuesFromList1(List<Integer> list) {
        List<Integer> listOfMaxValues = new ArrayList<>();

        List<Integer> currentList = new ArrayList<>(list);
        while (listOfMaxValues.size() < 3) {
            Integer currentMaxValue = Collections.max(currentList);
            listOfMaxValues.add(currentMaxValue);
            currentList.remove(currentMaxValue);
        }
        System.out.println(listOfMaxValues);
    }

    public static void findThreeMaxValuesFromList2(List<Integer> list) {
        List<Integer> listOfMaxValues = new ArrayList<>();

        List<Integer> currentList = new ArrayList<>(list);
        while (listOfMaxValues.size() < 3) {
            Integer currentMaxValue = currentList.get(0);
            for (Integer integer : currentList) {
                if (integer > currentMaxValue) {
                    currentMaxValue = integer;
                }
            }
            listOfMaxValues.add(currentMaxValue);
            currentList.remove(currentMaxValue);
        }

        System.out.println(listOfMaxValues);
    }

    public static void findThreeMaxValuesFromList3(List<Integer> list) {
        TreeSet<Integer> set = new TreeSet<>(list);

        while (set.size() != 3) {
            set.pollFirst();
        }
        System.out.println(set.descendingSet());
    }

    public static void main(String[] args) {
        findThreeMaxValuesFromList1(Arrays.asList(1, -45, 56, 0, -20, -100, 1000, 34, 200));
        findThreeMaxValuesFromList2(Arrays.asList(1, -45, 56, 0, -20, -100, 1000, 34, 200));
        findThreeMaxValuesFromList3(Arrays.asList(1, -45, 56, 0, -20, -100, 1000, 34, 200));
    }
}