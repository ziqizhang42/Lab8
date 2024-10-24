package com.example.lab8v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    public void testDeleteExistingCity() {
        City city = new City("Calgary", "Alberta");
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city);
        CustomList cityList = new CustomList(null, cities);

        assertTrue(cityList.hasCity(city), "City list should contain Calgary before deletion");

        cityList.deleteCity(city);

        assertFalse(cityList.hasCity(city), "City list should not contain Calgary after deletion");
        assertEquals(0, cityList.getCount(), "City count should be 0 after deleting Calgary");
    }

    @Test
    public void testDeleteNonExistingCity() {
        City city1 = new City("Vancouver", "British Columbia");
        City city2 = new City("Edmonton", "Alberta");
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        CustomList cityList = new CustomList(null, cities);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city2);
        });

        String expectedMessage = "City not found in the list.";
        String actualMessage = exception.getMessage();

        assert actualMessage != null;
        assertTrue(actualMessage.contains(expectedMessage), "Exception message should indicate city not found");
        assertEquals(1, cityList.getCount(), "City count should remain 1 after failed deletion");
    }

    @Test
    public void testCountCities() {
        ArrayList<City> cities = new ArrayList<>();
        CustomList cityList = new CustomList(null, cities);
        assertEquals(0, cityList.countCities(), "Initial city count should be 0");

        City city2 = new City("Montreal", "Quebec");
        ArrayList<City> cities2 = new ArrayList<>();
        cities2.add(city2);
        CustomList citiesList2 = new CustomList(null, cities2);
        assertEquals(1, cityList.countCities(), "City count should be 1 after adding Montreal");

        City city3 = new City("Quebec City", "Quebec");
        ArrayList<City> cities3 = new ArrayList<>();
        cities3.add(city2);
        cities3.add(city3);
        CustomList citiesList3 = new CustomList(null, cities3);
        assertEquals(2, cityList.countCities(), "City count should be 2 after adding Quebec City");

        cityList.deleteCity(city3);
        assertEquals(1, cityList.countCities(), "City count should be 1 after deleting Quebec City");
    }
}
