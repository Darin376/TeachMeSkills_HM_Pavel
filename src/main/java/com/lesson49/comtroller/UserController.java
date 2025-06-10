package com.lesson49.comtroller;

import com.lesson49.dto.CarDTO;
import com.lesson49.dto.CarUserDTO;
import com.lesson49.entity.Car;
import com.lesson49.entity.CarUser;
import com.lesson49.service.CarService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/carUser")
public class UserController {

    private final CarService carService;

    public UserController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Integer id, Model model) {
        CarUserDTO userDTO = carService.getCarUserById(id);
        CarDTO carDTO = carService.getCarById(id);
        List<CarDTO>  carDTOx5 = carService.getAllX5Cars();
        model.addAttribute("user", carDTO);
        System.out.println(carDTOx5);



//        System.out.println(carDTO);
        return "user/profile";
    }


    @DeleteMapping("/{CarUserID}")
    public ResponseEntity<?> getUserById(@PathVariable("CarUserID") int CarUserID) {
        Boolean isDelete = carService.deleteCarUserById(CarUserID);

        if (isDelete) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student id: " + CarUserID + " not found");
        }
    }

    @PostMapping("/new")
    public ResponseEntity<?> createStudent(@RequestBody CarUserDTO carUserDTO) {
        try {
            CarUser carUser = carService.createCarUser(carUserDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Student: " + carUser + " created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating student");
        }
    }


    @PostMapping("/newCar")
    public ResponseEntity<?> createNewCar(@RequestBody CarDTO carDTO) {
        try {
            Car car = carService.createCar(carDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    "Car: " + car + " created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating car: " + e.getMessage());

            // post запрос
//
//            {
//                "brand": "Toyota",
//                    "model": "Camry",
//                    "year": 2022,
//                    "license_plate": "A123BC",
//                    "userId": 4
//            }
        }
    }

}
