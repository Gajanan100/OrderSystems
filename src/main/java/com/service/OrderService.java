package com.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrderDao;
import com.entity.Order;

@Service
public class OrderService {
 @Autowired
 OrderDao od;
 
 
 public Order createOrder(Order order) {
	 
	 return od.save(order);
 }
 
	public List<Order> getLastDayOrder(int count) {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -count);

		Date date = cal.getTime();
		LocalDate date1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		System.out.println(formatter.format(date1));

		return od.findByOrderDateGreaterThanEqual(date1);
	}
	
	
	public int updateAmount(int id,int totolAmount) {
		Optional<Order> order= od.findById(id);
		
		if(order.isPresent()) {
			Order	order1=order.get();
			order1.setTotalAmount(totolAmount);
			
			od.save(order1);
			
		 return 1;
		}
		return 0;
	}
 
	
}
