package org.example.dao;

import org.example.mappers.PersonMapper;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person (full_name, year_of_bird) VALUES(?,?)"
                ,person.getFullName(), person.getYearOfBird());
    }

    public List<Person> showAllPersons() {
        return jdbcTemplate.query("SELECT * FROM person", new PersonMapper());
    }
}
