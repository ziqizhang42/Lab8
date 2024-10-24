package com.example.lab8v2;

import java.util.Objects;

public class City implements Comparable<City> {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;
        City other = (City) obj;
        return this.city.equals(other.city) && this.province.equals(other.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.city);
    }
}
