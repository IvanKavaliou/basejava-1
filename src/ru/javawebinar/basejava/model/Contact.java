package ru.javawebinar.basejava.model;

public class Contact {

    private ContactType contactType;
    private String contactValue;

    public Contact(ContactType contactType, String contactValue) {
        this.contactType = contactType;
        this.contactValue = contactValue;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactType=" + contactType +
                ", contactValue='" + contactValue + '\'' +
                '}';
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }
}
