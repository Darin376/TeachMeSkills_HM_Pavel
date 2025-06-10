package com.lesson49.mapper;

import com.lesson49.dto.CarUserDTO;
import com.lesson49.entity.CarUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarUserMapper {
    private final CarMapper carMapper;

    public CarUserDTO toDto(CarUser carUser) {
        if (carUser == null) return null;

        return CarUserDTO.builder()
                .id(carUser.getId())
                .name(carUser.getName())
                .surname(carUser.getSurname())
                .cars(carUser.getCars() == null ?
                        null :
                        carUser.getCars().stream()
                                .map(carMapper::toDto)
                                .toList())
                .build();
    }

    public CarUser toEntity(CarUserDTO carUserDTO) {
        if (carUserDTO == null) return null;

        CarUser carUser = new CarUser();
        carUser.setId(carUserDTO.getId());
        carUser.setName(carUserDTO.getName());
        carUser.setSurname(carUserDTO.getSurname());

        if (carUserDTO.getCars() != null) {
            carUser.setCars(
                    carUserDTO.getCars().stream()
                            .map(carDTO -> carMapper.toEntity(carDTO, carUser))
                            .toList()
            );
        }

        return carUser;
    }
}