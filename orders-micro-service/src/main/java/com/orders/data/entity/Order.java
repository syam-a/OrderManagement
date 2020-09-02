package com.orders.data.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "order_table")
public class Order {

	@Id
	@Column(name = "order_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderCode;

	@Column(name = "customer_name")
	private String customerName;

	@Temporal(TemporalType.DATE)
	@Column(name = "order_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date orderDate;

	@Column(name = "shipping_address")
	private String shippingAddress;

	@Transient
	private List<OrderItem> items;

	@Transient
	private float total;

	public Order() {

	}

	public Order(Long orderCode, String customerName, Date orderDate, String shippingAddress) {
		super();
		this.orderCode = orderCode;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		// this.items = items;
		// this.total = total;
	}

	public Long getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(Long orderCode) {
		this.orderCode = orderCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Transient
	public List<OrderItem> getItems() {
		return items;
	}

	@Transient
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	@Transient
	public float getTotal() {
		return total;
	}

	@Transient
	public void setTotal(float total) {
		this.total = total;
	}

}
