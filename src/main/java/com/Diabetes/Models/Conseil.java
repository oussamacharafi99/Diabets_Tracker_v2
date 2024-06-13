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
public class Conseil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime dateHeure;

    @ManyToOne
    @JoinColumn(name = "glycemie_id", nullable = false)
    private LectureGlycemie glycemie;

    public Conseil(String name){
        this.message = message;
    }


}
