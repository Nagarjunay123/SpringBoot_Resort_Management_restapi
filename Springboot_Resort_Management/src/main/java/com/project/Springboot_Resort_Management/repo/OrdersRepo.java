package com.project.Springboot_Resort_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Springboot_Resort_Management.dto.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Integer>{

}
