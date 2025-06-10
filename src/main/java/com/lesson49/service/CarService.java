package com.lesson49.service;

import com.lesson49.dao.CarRepository;
import com.lesson49.dto.CarDTO;
import com.lesson49.dto.CarUserDTO;
import com.lesson49.entity.Car;
import com.lesson49.entity.CarUser;
import com.lesson49.dao.CarUserRepository;
import com.lesson49.mapper.CarMapper;
import com.lesson49.mapper.CarUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarService {
    private final CarUserRepository carUserRepository;
    private final CarUserMapper carUserMapper;
    private final CarRepository carRepository;
    private final CarMapper carMapper;


    @Autowired
    public CarService(CarUserRepository carUserRepository,
                      CarUserMapper carUserMapper,
                      CarRepository carRepository,
                      CarMapper carMapper) {
        this.carUserRepository = carUserRepository;
        this.carUserMapper = carUserMapper;
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public CarUserDTO getCarUserById(Integer id) {
        CarUser carUser = carUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return carUserMapper.toDto(carUser);
    }

    public CarDTO getCarById(Integer id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return carMapper.toDto(car);
    }

    public List<CarDTO> getAllX5Cars() {
        List<Car> x5Cars = carRepository.findByModel("X5");
        return x5Cars.stream()
                .map(carMapper::toDto)
                .toList();
    }

    public boolean deleteCarUserById(int id) {
        boolean isExistsStudent = carUserRepository.existsById(id);
        if (isExistsStudent) {
            carUserRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public CarUser createCarUser(CarUserDTO carUserDTO) {
        if (carUserDTO == null) {
            throw new IllegalArgumentException("CarUserDTO cannot be null");
        }

        // Преобразуем DTO в сущность

        CarUser carUser = carUserMapper.toEntity(carUserDTO);
        // Валидация обязательных полей
        if (carUser.getName() == null || carUser.getName().isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (carUser.getSurname() == null || carUser.getSurname().isBlank()) {
            throw new IllegalArgumentException("Surname is required");
        }

        // Сохраняем сущность в базу данных
        carUser = carUserRepository.save(carUser);

        return carUser;
    }

    public Car createCar(CarDTO carDTO) {
        if (carDTO == null) {
            throw new IllegalArgumentException("CarUserDTO cannot be null");
        }
        CarUser user = carDTO.getUserId() != null
                ? carUserRepository.findById(carDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + carDTO.getUserId()))
                : null;
        // Преобразуем DTO в сущность

        Car car = carMapper.toEntity(carDTO, user);
        // Валидация обязательных полей
        if (car.getUser() == null) {
            throw new IllegalArgumentException("Name is required"); // Должно быть "User is required"
        }

        if (car.getBrand() == null || car.getBrand().isBlank()) {
            throw new IllegalArgumentException("Surname is required");
        }

        // Сохраняем сущность в базу данных
        car = carRepository.save(car);

        return car;
    }

}