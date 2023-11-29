/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.smartapp.exceptions;

/**
 *
 * @author Star
 */
public class CustomException extends IllegalArgumentException {
    public CustomException(String msg) {
        super(msg);
    }

}