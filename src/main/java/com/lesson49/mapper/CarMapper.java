package com.lesson49.mapper;

import com.lesson49.dto.CarDTO;
import com.lesson49.entity.Car;
import com.lesson49.entity.CarUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CarMapper {

    public CarDTO toDto(Car car) {
        if (car == null) return null;

        return CarDTO.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .licensePlate(car.getLicensePlate())
                .userId(car.getUser() != null ? car.getUser().getId() : null)
                .build();
    }

    public Car toEntity(CarDTO carDTO, CarUser user) {
        if (carDTO == null) return null;

        return Car.builder()
                .id(carDTO.getId())
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .year(carDTO.getYear())
                .licensePlate(carDTO.getLicensePlate())
                .user(user)
                .build();
    }

}

