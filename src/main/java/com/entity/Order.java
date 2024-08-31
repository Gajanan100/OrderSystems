package com.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
@Entity
@Table(name = "order_table")
public class Order {
	
	@Id
	@GeneratedValue
	private int id;
	private String customerName;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate orderDate;
	
	@Positive(message = "value must be positive and 2 digits")
	private double totalAmount;
	
	public Order() {
		super();
	}

	public Order(int id, String customerName, LocalDate orderDate, double totalAmount) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerName=" + customerName + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + "]";
	}
	
	
	
}
