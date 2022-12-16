package com.msz.SpringBootSingersTheymeLeafCrudApp.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//AOP - stuff for catch the exceptions to all type
@ControllerAdvice
public class SingersExceptionHandler {

    private SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
    private Date resultdate;
    private List<String> errorLisst = new ArrayList<>();

    // Add an exception handler forSingerNoFoundException and any Exception
    @ExceptionHandler
    public String handleException(Exception exc, Model theModel){
        resultdate = new Date(System.currentTimeMillis());

        errorLisst.add(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        errorLisst.add(exc.getMessage());
        errorLisst.add(resultdate.toString());

        theModel.addAttribute("singer_status",errorLisst.get(0));
        theModel.addAttribute("singer_message",errorLisst.get(1));
        theModel.addAttribute("singer_time_stamp",errorLisst.get(2));

        return "singers/singer-not-found";
    }

    @ExceptionHandler
    public String handleException(SingersNotFoundException exc, Model theModel){
        resultdate = new Date(System.currentTimeMillis());

        errorLisst.add(String.valueOf(HttpStatus.NOT_FOUND.value()));
        errorLisst.add(exc.getMessage());
        errorLisst.add(resultdate.toString());

        theModel.addAttribute("singer_status",errorLisst.get(0));
        theModel.addAttribute("singer_message",errorLisst.get(1));
        theModel.addAttribute("singer_time_stamp",errorLisst.get(2));

        return "singers/singer-not-found";
    }

}
