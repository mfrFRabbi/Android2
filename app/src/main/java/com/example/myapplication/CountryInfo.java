package com.example.myapplication;

import android.content.Context;

import java.util.List;

public class CountryInfo {
    String countryNames;
    int flag;

    public CountryInfo(String countryNames, int flag) {
        this.countryNames = countryNames;
        this.flag = flag;
    }

    public String getCountryNames() {
        return countryNames;
    }

    public int getFlag() {
        return flag;
    }
}
