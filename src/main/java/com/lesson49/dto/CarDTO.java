package com.lesson49.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {
    private int id;
    private String brand;
    private String model;
    private String licensePlate;
    private int year;
    private Integer userId;

}
