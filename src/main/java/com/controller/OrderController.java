package com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Order;
import com.service.OrderService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService os;
	
	public OrderController() {
		// TODO Auto-generated constructor stub
		System.out.println("controller is called.....");
		
		
	}
	
	@PostMapping("/createOrder")
	public Order createOrder(@Valid @ModelAttribute Order order) {
		System.out.println(order);
		return os.createOrder(order);
	}
	
	@GetMapping("/getAllDate/{count}")
	public List<Order>  getAllOrderBydate(@PathVariable int count){
		return os.getLastDayOrder(count);
	}
	
	@PutMapping("/updateAmount/{id}")
	public String updateTotalAmount(@PathVariable int id, @PathParam("totalAmount") int totalAmount) {
		int count=os.updateAmount(id, totalAmount);
		if(count>0)
		return "updated totalamount Successfully.......";
		else
			return "Id not found.......";
	}
	
	
}
