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
        CustomList cityList = new CityList();
        City city1 = new City("Toronto", "Ontario");
        City city2 = new City("Vancouver", "British Columbia");
        City cityDuplicate = new City("Toronto", "Ontario");

        cityList.add(city1);

        assertTrue(cityList.hasCity(city1), "City list should contain Toronto");
        assertTrue(cityList.hasCity(cityDuplicate), "City list should treat duplicate city with same fields as existing");
        assertFalse(cityList.hasCity(city2), "City list should not contain Vancouver");
    }
}
