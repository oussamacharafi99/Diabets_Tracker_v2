package com.Diabetes.Models;

import com.Diabetes.Models.Users.User;
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
public class Rapport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime dateGeneration;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private User utilisateur;



    public Rapport(LocalDateTime dateGeneration, String contenu, User utilisateur) {
        this.dateGeneration = dateGeneration;
        this.contenu = contenu;
        this.utilisateur = utilisateur;
    }

}
