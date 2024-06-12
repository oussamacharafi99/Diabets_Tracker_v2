package com.Diabetes.Models.Sport;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class Movements {

    @Id
    private Integer id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
}
