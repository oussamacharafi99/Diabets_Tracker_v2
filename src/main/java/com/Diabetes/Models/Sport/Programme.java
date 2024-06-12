package com.Diabetes.Models.Sport;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Programme {

    @Id
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
}
