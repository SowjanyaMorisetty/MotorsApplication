package com.example.MotorsApplication.service;

import com.example.MotorsApplication.entity.Motors;
import com.example.MotorsApplication.repository.MotorsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MotorsServiceTest {

    @Mock
    private MotorsRepository mockMotorsRepository;

    @InjectMocks
    private MotorsService motorsServiceUnderTest;

    @Test
    void testGetAllCars() {
        // Setup
        final List<Motors> expectedResult = List.of(new Motors(0, "carName", 0.0, "brand", "color", 0, "date", false));

        // Configure MotorsRepository.findAll(...).
        final List<Motors> motors = List.of(new Motors(0, "carName", 0.0, "brand", "color", 0, "date", false));
        when(mockMotorsRepository.findAll()).thenReturn(motors);

        // Run the test
        final List<Motors> result = motorsServiceUnderTest.getAllCars();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllCars_MotorsRepositoryReturnsNoItems() {
        // Setup
        when(mockMotorsRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Motors> result = motorsServiceUnderTest.getAllCars();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetAvailibilityDate() {
        // Setup
        final List<Motors> expectedResult = List.of(new Motors(0, "carName", 0.0, "brand", "color", 0, "date", false));

        // Configure MotorsRepository.findByDate(...).
        final List<Motors> motors = List.of(new Motors(0, "carName", 0.0, "brand", "color", 0, "date", false));
        when(mockMotorsRepository.findByDate("date")).thenReturn(motors);

        // Run the test
        final List<Motors> result = motorsServiceUnderTest.getAvailibilityDate("date");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAvailibilityDate_MotorsRepositoryReturnsNoItems() {
        // Setup
        when(mockMotorsRepository.findByDate("date")).thenReturn(Collections.emptyList());

        // Run the test
        final List<Motors> result = motorsServiceUnderTest.getAvailibilityDate("date");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
