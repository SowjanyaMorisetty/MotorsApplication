package com.example.MotorsApplication.controller;


import com.example.MotorsApplication.entity.Motors;
import com.example.MotorsApplication.service.MotorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sharathCars")
public class MotorsController {

    @Autowired
    private MotorsService motorsService;

    @GetMapping("/cars")
    public List<Motors> getAllCars()
    {
        return motorsService.getAllCars();
    }

    @GetMapping("/cars/{date}")
    public List<Motors> getAvailibilityDate(@PathVariable("date") String date)
    {
        return motorsService.getAvailibilityDate(date);
    }


}