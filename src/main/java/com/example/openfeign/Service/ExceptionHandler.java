package com.example.openfeign.Service;


import com.example.openfeign.controller.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice({"Controller.class"})
public class ExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RuntimeException exceptionHandler(Exception e){
        throw new RuntimeException(e.getMessage());
    }
}
