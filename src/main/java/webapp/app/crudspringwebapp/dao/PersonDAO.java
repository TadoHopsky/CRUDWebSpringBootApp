package webapp.app.crudspringwebapp.dao;

import org.springframework.stereotype.Component;
import webapp.app.crudspringwebapp.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNTER;
    private List<Person> personList;

    {
        personList = new ArrayList<>();
        personList.add(new Person(++PEOPLE_COUNTER, "Kseniya Frolova", "kseniya@yaandex.ru", 26));
        personList.add(new Person(++PEOPLE_COUNTER, "Arkadiy Frolov", "arkadiyFrolov@yaandex.ru", 25));
        personList.add(new Person(++PEOPLE_COUNTER, "Daniil Ostroverkh", "daniil13cm@yaandex.ru", 24));
        personList.add(new Person(++PEOPLE_COUNTER, "Sofia Chikhman", "sofialovesosa@yaandex.ru", 20));
    }   // Заполнение массива

    public List<Person> index() {
        return personList;
    }

    public Person show(int id) {
        return personList.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNTER);
        personList.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
        personToBeUpdated.setAge(updatedPerson.getAge());
    }
    public void delete(int id) {
        personList.removeIf(person -> person.getId() == id);
    }
}
