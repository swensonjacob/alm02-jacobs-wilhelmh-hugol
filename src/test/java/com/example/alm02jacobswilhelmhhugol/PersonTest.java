package com.example.alm02jacobswilhelmhhugol;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PersonTest {
    Person person = new Person("Hugo Lindmark","Sweden",29);
    @Test
    void getFullName() {
        assertTrue(person.getFullName().equals("Pelle"));

    }

    @Test
    void setFullName() {
        person.setFullName("Pelle Svanslös");
        assertTrue(person.getFullName().equals("Pelle Svanslös"));
        assertFalse(person.getFullName().equals("Hugo Lindmark"));
    }

    @Test
    void getNationality() {
        assertTrue(person.getNationality().equals("Sweden"));
    }

    @Test
    void setNationality() {
        person.setNationality("Uganda");
        assertTrue(person.getNationality().equals("Uganda"));
        assertFalse(person.getNationality().equals("Sweden"));
    }

    @Test
    void getAge() {
        assertTrue(person.getAge() == 29);

    }

    @Test
    void setAge() {
        person.setAge(32);
        assertTrue(person.getAge() == 32);
        assertFalse(person.getAge() == 29);

    }
}
