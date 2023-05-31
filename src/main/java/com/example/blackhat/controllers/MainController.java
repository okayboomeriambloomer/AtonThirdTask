package com.example.blackhat.controllers;


import com.example.blackhat.DAO.PersonDAO;
import com.example.blackhat.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private final PersonDAO personDAO;

    @Autowired
    public MainController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String getHomePage() {
        return "homepage";
    }

    @GetMapping("/getName")
    public String getName(@RequestParam("numberPhone") String numberPhone, Model model) {
        String name = personDAO.getNameOfPerson(numberPhone);
        model.addAttribute("name", name);
        return "homepage";
    }

    @PostMapping
    public ResponseEntity getSuperSecretData(@RequestBody List<Person> data) {
        personDAO.addSecretData(data);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
