package com.aquadrat.parkplatzverwaltung.controller;

import com.aquadrat.parkplatzverwaltung.model.dto.VehicleDto;
import com.aquadrat.parkplatzverwaltung.model.enums.VehicleType;
import com.aquadrat.parkplatzverwaltung.service.VehicleService;
import com.aquadrat.parkplatzverwaltung.support.VehicleTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class VehicleControllerTest {
    private VehicleService vehicleService;
    private VehicleController vehicleController;

    @BeforeEach
    public void setUp() {
        vehicleService = mock(VehicleService.class);
        vehicleController = new VehicleController(vehicleService);

    }

    @Test
    public void getAllTest() {
        List<VehicleDto> vehicleDtoList = VehicleTestSupport.generateVehicleDtoListWithCount(5);
        when(vehicleService.getAll()).thenReturn(vehicleDtoList);
        ResponseEntity<List<VehicleDto>> response = vehicleController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(response.getBody(), vehicleDtoList);
        verify(vehicleService).getAll();
    }
}
