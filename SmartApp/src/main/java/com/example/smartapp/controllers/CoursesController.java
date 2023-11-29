/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.smartapp.controllers;

import com.example.smartapp.common.ApiResponse;
import com.example.smartapp.model.Courses;
import com.example.smartapp.service.CoursesService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Star
 */
@RestController
@RequestMapping("/courses")
public class CoursesController {
    
     @Autowired
    CoursesService coursesService;

    @PostMapping("/create")
      public ResponseEntity<ApiResponse> createCourse(@RequestBody Courses courses) {
        courses.setCreationDate(LocalDateTime.now());
        coursesService.createCourse(courses);
         return new ResponseEntity<>(new ApiResponse(true, "a new course created"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Courses> listCourses() {
        return coursesService.listCourses();
    }
    @PostMapping("/update/{coursesId}")
    public ResponseEntity<ApiResponse> updateCourse(@PathVariable("coursesId") int coursesId, @RequestBody Courses courses ) {
        System.out.println("courses  id " + coursesId);
        if (!coursesService.findById(coursesId)) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "course does not exists"), HttpStatus.NOT_FOUND);
        }
        coursesService.editCourse(coursesId, courses);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "course has been updated"), HttpStatus.OK);
    }
}
