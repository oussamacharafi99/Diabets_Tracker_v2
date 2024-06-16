package com.Diabetes.Service.RepasService;

import com.Diabetes.Models.LectureGlycemie;
import com.Diabetes.Models.Repas.Repas;
import com.Diabetes.Repository.Repas.RepasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
public class Repasservice {


    @Autowired
    private RepasRepository RepasRepos;

    @Transactional
    public void addRepas(Repas Rp) {
        RepasRepos.save(Rp);
    }





}
