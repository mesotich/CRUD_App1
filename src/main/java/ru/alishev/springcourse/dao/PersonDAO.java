package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom",23,"we@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob",48,"der@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike",23,"web@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 34, "asx@yandex.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToUpdated = show(id);
        personToUpdated.setName(updatedPerson.getName());
        personToUpdated.setAge(updatedPerson.getAge());
        personToUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
