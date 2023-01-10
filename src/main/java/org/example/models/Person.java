package org.example.models;

import java.util.Objects;

public class Person {
    private Long id;
    private String fullName;
    private Integer yearOfBird;

    public Person() {
    }

    public Person(String fullName, Integer yearOfBird) {
        this.fullName = fullName;
        this.yearOfBird = yearOfBird;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getYearOfBird() {
        return yearOfBird;
    }

    public void setYearOfBird(Integer yearOfBird) {
        this.yearOfBird = yearOfBird;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(fullName, person.fullName) &&
                Objects.equals(yearOfBird, person.yearOfBird);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, yearOfBird);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", yearOfBird=" + yearOfBird +
                '}';
    }
}
