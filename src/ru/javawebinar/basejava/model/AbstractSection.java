package ru.javawebinar.basejava.model;

public abstract class AbstractSection  implements Section{

    private SectionType type;

    private String name;

    public AbstractSection(SectionType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractSection{" +
                "type=" + type +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public abstract void print();


    public SectionType getType() {
        return type;
    }

    public void setType(SectionType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
