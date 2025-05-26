package com.lesson49.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "usercard")
public class Usercard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String card;

    @Column
    private int money;

    @JsonBackReference  // Обратная ссылка (не будет в JSON)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Bankuser bankuser;
}