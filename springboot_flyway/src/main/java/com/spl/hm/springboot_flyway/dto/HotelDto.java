package com.spl.hm.springboot_flyway.dto;

import java.util.Date;

import com.spl.hm.springboot_flyway.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String email;
    private String phoneNumber;
    private Date createdAt;
    private Date updatedAt;

    public static Hotel toEntity(HotelDto dto) {
        return Hotel.builder()
            .id(dto.getId())
            .name(dto.getName())
            .address(dto.getAddress())
            .city(dto.getCity())
            .email(dto.getEmail())
            .phoneNumber(dto.getPhoneNumber())
            .build();
    }

    public static HotelDto toDto(Hotel hotel) {
        return HotelDto.builder()
            .id(hotel.getId())
            .name(hotel.getName())
            .address(hotel.getAddress())
            .city(hotel.getCity())
            .email(hotel.getEmail())
            .phoneNumber(hotel.getPhoneNumber())
            .createdAt(hotel.getCreatedAt())
            .updatedAt(hotel.getUpdatedAt())
            .build();
    }

}
