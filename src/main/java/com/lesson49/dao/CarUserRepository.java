package com.lesson49.dao;

import com.lesson49.entity.CarUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarUserRepository extends JpaRepository<CarUser, Integer> {
    List<CarUser> findByNameIgnoreCase(String name);
    List<CarUser> findBySurnameIgnoreCase(String surname);
}