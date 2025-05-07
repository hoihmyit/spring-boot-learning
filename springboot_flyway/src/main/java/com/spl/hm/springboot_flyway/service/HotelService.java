package com.spl.hm.springboot_flyway.service;

import java.util.List;
import java.util.stream.Collectors;

import com.spl.hm.springboot_flyway.dto.HotelDto;
import com.spl.hm.springboot_flyway.entity.Hotel;
import com.spl.hm.springboot_flyway.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(final HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDto> getAllHotels() {
        return hotelRepository.findAll().stream()
            .map(HotelDto::toDto)
            .collect(Collectors.toList());
    }

    public HotelDto getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Hotel not found with id: " + id));
        return HotelDto.toDto(hotel);
    }

    @Transactional
    public HotelDto saveHotel(HotelDto hotelDto) {
        Hotel hotel = hotelRepository.saveAndFlush(HotelDto.toEntity(hotelDto));
        return HotelDto.toDto(hotel);
    }
}
