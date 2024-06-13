package com.Diabetes.Service.ServiceSport;
import com.Diabetes.Models.Sport.Movements;
import com.Diabetes.Models.Sport.Programme;
import com.Diabetes.Models.Sport.ProgrammeMovements;
import com.Diabetes.Repository.SportRepository.MovementsRepository;
import com.Diabetes.Repository.SportRepository.ProgrammeMovementsRepository;
import com.Diabetes.Repository.SportRepository.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSport {
    @Autowired
    ProgrammeMovementsRepository programmeMovementsRepository;
    @Autowired
    ProgrammeRepository programmeRepository;
    @Autowired
    MovementsRepository movementsRepository;

    public void saveProMov(ProgrammeMovements programmeMovements) {
        programmeMovementsRepository.save(programmeMovements);
    }
    public List<ProgrammeMovements> getProMov(ProgrammeMovements programmeMovements) {
        return programmeMovementsRepository.findAll(programmeMovements);
    }
    public void updateProMov(ProgrammeMovements programmeMovements) {
        programmeMovementsRepository.save(programmeMovements);
    }
    public void deleteProMov(ProgrammeMovements programmeMovements) {
        programmeMovementsRepository.delete(programmeMovements);
    }

    /* Section of Programme */

    public void savePro(Programme programme) {
        programmeRepository.save(programme);
    }
    public List<Programme> getPro(Programme programme) {
        return programmeRepository.findAll(programme);
    }

    /* Section of Movements */

    public List<Movements> getMovements(Movements movements) {
        return movementsRepository.findAll(movements);
    }

    /* Section of Find All From ProgrammeMovements */


}
