package com.example.demo.repositories;

import com.example.demo.entities.Order2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order2, Long> {

}
