package com.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	
	public List<Order> findByOrderDateGreaterThanEqual(LocalDate date);

}
