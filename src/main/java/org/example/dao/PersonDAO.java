package org.example.dao;

import org.example.mappers.BookMapper;
import org.example.mappers.PersonMapper;
import org.example.models.Book;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person (full_name, year_of_bird) VALUES(?,?)"
                , person.getFullName(), person.getYearOfBird());
    }

    public List<Person> getAll() {
        return jdbcTemplate.query("SELECT * FROM person", new PersonMapper());
    }

    public Person get(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
    }

    public void update(int id, Person personUp) {
        jdbcTemplate.update("UPDATE person SET full_name = ? , year_of_birf = ? WHERE id = ?",
                personUp.getFullName(), personUp.getYearOfBird(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id = ?", id);
    }

    public List<Book> getBooksByPerson(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id = ?",
                new Object[]{id}, new BookMapper());
    }

    public Optional<Person> getPersonByFullName(String fullName) {
        return jdbcTemplate.query("SELECT * FROM person WHERE full_name = ?",
                new Object[]{fullName}, new PersonMapper()).stream().findAny();
    }
}
