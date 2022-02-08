package com.javc.wildcards;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class WildCardsTest {

    public static <T> void iterateUsersGeneric(List<T> collection) {
        for (T user : collection) {
            System.out.println(user);
        }
    }

    public static void iterateUsersWithCommonType(List collection) {
        for (Object user : collection) {
            System.out.println(user);
        }
    }

    //для класса User и всех его наследников
    public static void iterateUsersWithWildCard(List<? extends User> collection) {
        for (User user : collection) {
            System.out.println(user);
        }
    }

    //для класса Consultant и всех его предков
    public static void iterateUsersWithWildCard2(List<? super Consultant> collection) {
        for (Object user : collection) {
            System.out.println(user);
        }
    }

    public static void main(String[] args) {
        List<Consultant> consultants = new ArrayList<>();
        consultants.add(new Consultant());
        consultants.add(new Consultant());

        List<Therapist> therapists = new ArrayList<>();
        therapists.add(new Therapist());
        therapists.add(new Therapist());

        iterateUsersWithWildCard(consultants);
        iterateUsersWithWildCard(therapists);

        iterateUsersWithWildCard2(consultants);
//        iterateUsersWithWildCard2(therapists);

//        List<Object> list = consultants;
//        List<User> list = consultants;
        List<? extends User> list = consultants;
    }
}