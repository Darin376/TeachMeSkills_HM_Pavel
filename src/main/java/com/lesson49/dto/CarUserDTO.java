package com.lesson49.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarUserDTO {
    private int id;
    private String name;
    private String surname;
    private List<CarDTO> cars;
}
