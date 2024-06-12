package com.Diabetes.Service;

import com.Diabetes.Models.test;
import com.Diabetes.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestImp {
    @Autowired
    TestRepository testRepository;


    @Transactional
    public void addTest(test test){
        testRepository.save(test);
    }
}
