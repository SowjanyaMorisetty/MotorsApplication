package com.example.MotorsApplication.service;

import com.example.MotorsApplication.entity.Motors;
import com.example.MotorsApplication.repository.MotorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service


public class MotorsService {

    @Autowired
    private MotorsRepository motorsRepository;

    public List<Motors> getAllCars() {
        return motorsRepository.findAll();
    }


    public List<Motors> getAvailibilityDate(String date) {
        return motorsRepository.findByDate(date);
    }
}

