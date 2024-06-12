package com.Diabetes.Models;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class LectureGlycemie {
    @Id   
    private Integer id;
    @Column
    private Integer valeur;
   @Column
    private LocalDateTime time;
    

}
