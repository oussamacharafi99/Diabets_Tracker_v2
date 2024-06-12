package com.Diabetes.Models.Sport;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgrammeMovements {

    @EmbeddedId
    private PM id;

    @ManyToOne
    @MapsId("programmeId")
    @JoinColumn(name = "programme_id")
    private Programme programme;

    @ManyToOne
    @MapsId("movementId")
    @JoinColumn(name = "movement_id")
    private Movements movements;

}
