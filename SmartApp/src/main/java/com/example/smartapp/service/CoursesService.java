/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.smartapp.service;

import com.example.smartapp.model.Courses;
import com.example.smartapp.repository.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
/**
 *
 * @author Star
 */
@Service
public class CoursesService {
    
    @Autowired
    CoursesRepo coursesRepo;
    
     public void createCourse(Courses courses) {
        coursesRepo.save(courses);
    }

    public List<Courses> listCourses() {
        return coursesRepo.findAll();
    }
    public void editCourse(int categoryId, Courses updateCourse) {
        Courses courses = coursesRepo.getById(categoryId);
        courses.setCoursesName(updateCourse.getCoursesName());
        courses.setDescription(updateCourse.getDescription());
        courses.setImageUrl(updateCourse.getImageUrl());
        coursesRepo.save(courses);
    }
    
     public boolean findById(int coursesId) {
        return coursesRepo.findById(coursesId).isPresent();
    }
}
