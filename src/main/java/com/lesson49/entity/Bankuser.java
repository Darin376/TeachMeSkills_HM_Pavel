package com.lesson49.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "bankuser")
public class Bankuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    @JsonManagedReference  // Управляемая часть связи (будет в JSON)
    @OneToMany(mappedBy = "bankuser")
    private List<Usercard> usercard;
}