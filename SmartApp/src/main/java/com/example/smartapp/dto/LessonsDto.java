/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.smartapp.dto;


import javax.validation.constraints.NotNull;

/**
 *
 * @author Star
 */
public class LessonsDto {
    
    private Integer id;
    
    private @NotNull String name;
    private @NotNull String fileUrl;
    private @NotNull String description;
    private @NotNull Integer coursesId;
    
   

    
     public LessonsDto() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the fileUrl
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * @param fileUrl the fileUrl to set
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the coursesId
     */
    public Integer getCoursesId() {
        return coursesId;
    }

    /**
     * @param coursesId the coursesId to set
     */
    public void setCoursesId(Integer coursesId) {
        this.coursesId = coursesId;
    }
    
}
