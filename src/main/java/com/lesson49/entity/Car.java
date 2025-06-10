package com.lesson49.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private int year;

    @Column(name = "license_plate")  // Лучше явно указать name, так как имя содержит underscore
    private String licensePlate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")  // Внешний ключ
    private CarUser user;


    @Override
    public String toString() {
        return "Car{id=gggggggggggg" + id + ", brand='" + brand + "', model='" + model + "'}";
    }
}