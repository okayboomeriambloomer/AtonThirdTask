package com.example.blackhat.DAO;

import com.example.blackhat.models.Person;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonDAO {

    HashMap<String, String> map;

    public void addSecretData(List<Person> data) {
        if (map == null) map = new HashMap<>();
        for (Person person : data) {
            map.put(person.getTelephoneNumber(), person.getName());
        }
    }

    public String getNameOfPerson(String numberPhone) {
        return map.getOrDefault(numberPhone, "Такого нет");
    }
}
