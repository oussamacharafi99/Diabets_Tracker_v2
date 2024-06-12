package com.Diabetes.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conseil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String message;
    private LocalDateTime dateHeure;
    public Conseil(String name){
        this.message = message;
    }

   // @ManyToOne
    //@JoinColumn(name = "utilisateur_id")
   // private Utilisateur utilisateur;

}
