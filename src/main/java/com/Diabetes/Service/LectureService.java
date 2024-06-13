// LectureService.java
package com.Diabetes.Service;

import com.Diabetes.Models.LectureGlycemie;
import com.Diabetes.Repository.LectureGlycemieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class LectureService {

    @Autowired
    private LectureGlycemieRepository lectureRepository;

    @Transactional
    public void addLecture(LectureGlycemie gr) {
        lectureRepository.save(gr);
    }
    @Transactional
    public ArrayList<LectureGlycemie> ShowDiabetes() {
        return (ArrayList<LectureGlycemie>) lectureRepository.findAll();

    }
    @Transactional
    public void delete(Integer id) {
        lectureRepository.deleteById(id);
    }


}