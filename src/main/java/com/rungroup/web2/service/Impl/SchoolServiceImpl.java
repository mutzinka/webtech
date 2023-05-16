package com.rungroup.web2.service.Impl;

import com.rungroup.web2.model.school;
import com.rungroup.web2.repository.SchoolRepository;
import com.rungroup.web2.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SchoolServiceImpl implements SchoolService {

    private SchoolRepository schoolRepository;


    @Autowired
    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<school> findAllschools() {

        List<school> display = schoolRepository.findAll();

        return display  ;
    }

    @Override
    public String saveSchool(school sch) {
        schoolRepository.save(sch);
        return "Saved Successfully";
    }

    @Override
    public void delete(long schoolId) {
        schoolRepository.deleteById(schoolId);
    }

    @Override
    public void update(school sch) {
        schoolRepository.save(sch);
    }

    @Override
    public school findById(long user_id) {
        school sch= schoolRepository.findById(user_id);
        return sch;
    }


}
