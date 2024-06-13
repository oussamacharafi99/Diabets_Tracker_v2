package com.Diabetes.Models.Sport;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
public class ProgrammeAndMovementsDTO {
    private Integer programmeId;
    private String programmeName;
    private Integer userId;
    private LocalDate startDate;
    private LocalTime hours;
    private LocalDate endDate;
    private String programmeDescription;
    private Integer movementId;
    private String movementName;
    private String image;
    private String movementDescription;

    public ProgrammeAndMovementsDTO(Integer programmeId, String programmeName, Integer userId, LocalDate startDate, LocalTime hours, LocalDate endDate, String programmeDescription, Integer movementId, String movementName, String image, String movementDescription) {
        this.programmeId = programmeId;
        this.programmeName = programmeName;
        this.userId = userId;
        this.startDate = startDate;
        this.hours = hours;
        this.endDate = endDate;
        this.programmeDescription = programmeDescription;
        this.movementId = movementId;
        this.movementName = movementName;
        this.image = image;
        this.movementDescription = movementDescription;
    }

}
