package com.javc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DaysOfWeek {

    MONDAY ("Понедельник","1st"),
    TUESDAY ("Вторник","2nd"),
    WEDNESDAY ("Среда","3rd"),
    THURSDAY ("Четверг","4th"),
    FRIDAY ("Пятница","5th"),
    SATURDAY ("Суббота","6th"),
    SUNDAY ("Воскресенье","7th");

    private String fullName;
    private String shortName;
}