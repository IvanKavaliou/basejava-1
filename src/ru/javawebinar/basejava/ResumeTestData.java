package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.util.Date;
import java.util.List;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume r1 = new Resume("name 1");
        Contact contact = new Contact(ContactType.EMAIL, "asd@asd.ru");
        r1.addContact(contact);
        SectionImpl s1 = new SectionImpl(SectionType.ACHIEVEMENT, "Dostizenia");
        s1.addSting("asdasd");
        Expire expire = new Expire(new Date(), new Date(), "Job1", "asdasdasdasdasdasd");
        s1.addExpire(expire);
        r1.addSection(s1);

        System.out.println(r1);
    }
}
