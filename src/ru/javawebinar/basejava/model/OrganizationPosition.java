package ru.javawebinar.basejava.model;

import java.time.LocalDate;

public class OrganizationPosition {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;

    public OrganizationPosition(LocalDate startDate, LocalDate endDate, String title) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
    }

    @Override
    public String toString() {
        return "OrganizationPosition{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                '}';
    }
}
