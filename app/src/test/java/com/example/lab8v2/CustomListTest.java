package com.example.lab8v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list =  new CustomList(null,new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity() {
        ArrayList<City> cities = new ArrayList<>();
        City city1 = new City("Toronto", "Ontario");
        City city2 = new City("Vancouver", "British Columbia");
        cities.add(city1);
        CustomList cityList = new CustomList(null, cities);

        assertTrue(cityList.hasCity(city1), "City list should contain Toronto");
        assertFalse(cityList.hasCity(city2), "City list should not contain Vancouver");
    }
}
