package com.Diabetes.Service.ServiceSport;

import com.Diabetes.Models.Sport.Movements;
import com.Diabetes.Models.Sport.Programme;
import com.Diabetes.Models.Sport.ProgrammeMovements;
import com.Diabetes.Models.Sport.ProgrammeAndMovementsDTO;
import com.Diabetes.Repository.SportRepository.MovementsRepository;
import com.Diabetes.Repository.SportRepository.ProgrammeMovementsRepository;
import com.Diabetes.Repository.SportRepository.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSport {

    @Autowired
    private ProgrammeMovementsRepository programmeMovementsRepository;
    @Autowired
    private ProgrammeRepository programmeRepository;
    @Autowired
    private MovementsRepository movementsRepository;

    public void saveProMov(ProgrammeMovements programmeMovements) {
        programmeMovementsRepository.save(programmeMovements);
    }

    public List<ProgrammeAndMovementsDTO> getProgrammeAndMovementsByProgrammeId(Integer programmeId) {
        return programmeMovementsRepository.findProgrammeAndMovementsByProgrammeId(programmeId);
    }

    public List<ProgrammeMovements> getProMov() {
        return programmeMovementsRepository.findAll();
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

    public List<Programme> getPro() {
        return programmeRepository.findAll();
    }
    public Programme getLatestProgramme(Integer userId){
        return programmeRepository.findLatestProgrammeByUserId(userId);
    }

    /* Section of Movements */

    public List<Movements> getMovements() {
        return movementsRepository.findAll();
    }
}
