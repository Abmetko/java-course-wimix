package com.javc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneVendors {

    APPLE("iPhone"),
    SAMSUNG("Galaxy");

    private String name;
}