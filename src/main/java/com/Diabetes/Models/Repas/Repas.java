package com.Diabetes.Models.Repas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Repas")
public class Repas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer repasId;
    @Column
    private long id;

    @Column
    private String repasName;

    @Column
    private String repasDescription;

    @Column
    private String Description;

    @Column
    private Double glicydes;

    @Column
    private String type;

    @Column
    private String Ingredients;


}
