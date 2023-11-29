/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.smartapp.service;


import com.example.smartapp.dto.LessonsDto;
import com.example.smartapp.model.Courses;
import com.example.smartapp.model.Lessons;
import com.example.smartapp.repository.LessonsRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Star
 */
@Service
public class LessonsService {
    
    @Autowired
    LessonsRepo lessonsRepo;  

    public void createLesson(LessonsDto lessonsDto, Courses courses) {
        Lessons  lessons = new Lessons();
        lessons.setDescription(lessonsDto.getDescription());
        lessons.setFileUrl(lessonsDto.getFileUrl());
        lessons.setName(lessonsDto.getName());
        lessons.setCourses(courses);
        lessonsRepo.save(lessons); 
    }

    public List<LessonsDto> getAllLessons() {
      List<Lessons> allLessons = lessonsRepo.findAll();

        List<LessonsDto> lessonsDtos = new ArrayList<>();
        for(Lessons lessons: allLessons) {
            lessonsDtos.add(getLessonsDto(lessons));
        }
        return lessonsDtos;
    }

    private LessonsDto getLessonsDto(Lessons lessons) {
        LessonsDto lessonsDto= new LessonsDto();
        lessonsDto.setDescription(lessons.getDescription());
        lessonsDto.setFileUrl(lessons.getFileUrl());
        lessonsDto.setName(lessons.getName());
        lessonsDto.setCoursesId(lessons.getCourses().getId());
        lessonsDto.setId(lessons.getId());  
        return lessonsDto;
    }
    public void updateLesson(LessonsDto lessonsDto, Integer lessonId)throws Exception {
         Optional<Lessons> optionalLesson = lessonsRepo.findById(lessonId);
         if (!optionalLesson.isPresent()) {
            throw new Exception("lesson not present");
        }
        Lessons  lessons = optionalLesson.get();
        lessons.setDescription(lessonsDto.getDescription());
        lessons.setFileUrl(lessonsDto.getFileUrl());
        lessons.setName(lessonsDto.getName());
        
        lessonsRepo.save(lessons); 
    }
}
