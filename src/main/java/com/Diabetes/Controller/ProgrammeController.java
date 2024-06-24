package com.Diabetes.Controller;
import com.Diabetes.Models.Sport.Programme;
import com.Diabetes.Repository.SportRepository.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProgrammeController {

    @Autowired
    private ProgrammeRepository programmeRepository;

    @GetMapping("/programmes")
    public List<Programme> getAllProgrammes() {
        return programmeRepository.findAll();
    }
}
