package org.acme.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class HolidayType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holidayType_seq")
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "holiday_id")
    private PublicHoliday holiday;

    public HolidayType() {
        super();
    }

    public HolidayType(int id, String name, PublicHoliday holiday) {
        this.id = id;
        this.name = name;
        this.holiday = holiday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PublicHoliday getHoliday() {
        return holiday;
    }

    public void setHoliday(PublicHoliday holiday) {
        this.holiday = holiday;
    }
}
