package com.spl.hm.springboot_flyway.controller;

import java.util.List;

import com.spl.hm.springboot_flyway.dto.HotelDto;
import com.spl.hm.springboot_flyway.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(final HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDto>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<HotelDto> getHotel(@PathVariable Long id) {
        HotelDto hotelDto = hotelService.getHotelById(id);
        return ResponseEntity.ok(hotelDto);
    }

    @PostMapping("/hotels")
    public ResponseEntity<HotelDto> saveHotel(@RequestBody HotelDto hotelDto) {
        HotelDto hotel = hotelService.saveHotel(hotelDto);
        return ResponseEntity.ok(hotel);
    }
}
