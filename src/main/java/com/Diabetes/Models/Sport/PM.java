package com.Diabetes.Models.Sport;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PM implements Serializable {

    private Integer programmeId;
    private Integer movementId;

    public PM() {}

    public PM(Integer programmeId, Integer movementId) {
        this.programmeId = programmeId;
        this.movementId = movementId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PM that = (PM) o;
        return Objects.equals(programmeId, that.programmeId) &&
                Objects.equals(movementId, that.movementId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programmeId, movementId);
    }
}
