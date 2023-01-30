package org.example.controllers;

import org.example.dao.PersonDAO;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDAO personDAO;

    @Autowired
    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "/newPerson";
    }

    @PostMapping()
    public String save(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/person/main";
    }

    @GetMapping("main")
    public String main(){
        return "/people";
    }


}
