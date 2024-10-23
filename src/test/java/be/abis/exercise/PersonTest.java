package be.abis.exercise;

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;

public class PersonTest {

    public static void main(String[] args) {
        Address address = new Address("Spiegelstraat", 50, "3000", "Leuven");
        Company company = new Company("Abis", "0123456789", "111333444", address);
        Person person = new Person(123456, "John", "Doe", 35, "john.doe@abis.be", "myPwd", "Nederlands", company);
        System.out.println(person.getFirstName() + " " + person.getLastName() + " is " + person.getAge() + " years old and works for " + person.getCompany().getName() + " in " + person.getCompany().getAddress().getTown() + ".");
        System.out.println(person);
    }
}
