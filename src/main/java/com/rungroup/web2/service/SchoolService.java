package com.rungroup.web2.service;

import com.rungroup.web2.model.school;

import java.util.List;

public interface SchoolService {

    List<school> findAllschools();

     String saveSchool(school sch);

    void delete(long schoolId);

    void update(school sch);


    school findById(long user_id);
}
