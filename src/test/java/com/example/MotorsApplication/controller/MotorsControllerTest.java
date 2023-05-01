package com.example.MotorsApplication.controller;

import com.example.MotorsApplication.entity.Motors;
import com.example.MotorsApplication.service.MotorsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MotorsController.class)
class MotorsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MotorsService mockMotorsService;

    @Test
    void testGetAllCars() throws Exception {
        // Setup
        // Configure MotorsService.getAllCars(...).
        final List<Motors> motors = List.of(new Motors(0, "carName", 0.0, "brand", "color", 0, "date", false));
        when(mockMotorsService.getAllCars()).thenReturn(motors);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/sharathCars/cars")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testGetAllCars_MotorsServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockMotorsService.getAllCars()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/sharathCars/cars")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testGetAvailibilityDate() throws Exception {
        // Setup
        // Configure MotorsService.getAvailibilityDate(...).
        final List<Motors> motors = List.of(new Motors(0, "carName", 0.0, "brand", "color", 0, "date", false));
        when(mockMotorsService.getAvailibilityDate("date")).thenReturn(motors);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/sharathCars/cars/{date}", "date")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void testGetAvailibilityDate_MotorsServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockMotorsService.getAvailibilityDate("date")).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/sharathCars/cars/{date}", "date")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
