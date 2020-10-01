package com.interstellarcarrental.carrental.repositories;

import com.interstellarcarrental.carrental.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, Long> {
    
}
