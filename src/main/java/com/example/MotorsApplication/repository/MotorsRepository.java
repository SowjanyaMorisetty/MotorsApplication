package com.example.MotorsApplication.repository;

import com.example.MotorsApplication.entity.Motors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MotorsRepository extends JpaRepository<Motors,Integer> {


    List<Motors> findByDate(String date);
}
