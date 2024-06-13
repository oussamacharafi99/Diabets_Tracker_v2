package com.Diabetes.Models;


import jakarta.persistence.*;


import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LectureGlycemie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    private double valeur;
    @Column
    private Time time;
    @Column
    private Date Date_of_Tracking ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate_of_Tracking() {
        return Date_of_Tracking;
    }

    public void setDate_of_Tracking(Date date_of_Tracking) {
        Date_of_Tracking = date_of_Tracking;
    }



}