package com.Diabetes.Models.Sport;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Programme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "startDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "heurs")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime heurs;

    @Column(name = "endDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String description;
}
