/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.smartapp.controllers;

import com.example.smartapp.common.ApiResponse;
import com.example.smartapp.dto.LessonsDto;
import com.example.smartapp.model.Courses;
import com.example.smartapp.repository.CoursesRepo;
import com.example.smartapp.service.LessonsService;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/lessons")
public class LessonsController {
    @Autowired
    LessonsService lessonsService;

    @Autowired
    CoursesRepo coursesRepo;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody LessonsDto lessonsDto) {
         Optional<Courses> oprionalLessons = coursesRepo.findById(lessonsDto.getCoursesId());
         if (!oprionalLessons.isPresent()) {
             return new ResponseEntity<ApiResponse>(new ApiResponse(false, "course does not exists"), HttpStatus.BAD_REQUEST);
         }
         lessonsService.createLesson(lessonsDto, oprionalLessons.get());
         return new ResponseEntity<ApiResponse>(new ApiResponse(true, "lesson has been added"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<LessonsDto>> getLessons() {
        List<LessonsDto> lessons = lessonsService.getAllLessons();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }
    @PostMapping("/update/{lessonId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("lessonId") Integer lessonId, @RequestBody LessonsDto lessonsDto) throws Exception {
        Optional<Courses> optionalCategory = coursesRepo.findById(lessonsDto.getCoursesId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "lesson does not exists"), HttpStatus.BAD_REQUEST);
        }
        lessonsService.updateLesson(lessonsDto, lessonId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "lesson has been updated"), HttpStatus.OK);
    }

}
