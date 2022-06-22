package ru.javawebinar.basejava.model;

import java.util.Date;

public class Expire {

    private Date dateFrom;
    private Date dateTo;
    private String name;
    private String text;

    public Expire(Date dateFrom, Date dateTo, String name, String text) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Expire{" +
                "dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
