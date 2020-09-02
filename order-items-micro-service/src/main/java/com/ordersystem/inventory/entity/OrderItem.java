package com.ordersystem.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_item_table")
public class OrderItem {

	@Id
	@Column(name = "product_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productCode;

	@Column(name = "product_order_code")
	private String productOrderCode;
	
	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "product_cost_per_unit")
	private float productCostPerUnit;

	
	public OrderItem() {

	}

	public OrderItem(Long productCode, String productOrderCode, String productName, int productQuantity,
			float productCostPerUnit) {
		super();
		this.productCode = productCode;
		this.productOrderCode = productOrderCode;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productCostPerUnit = productCostPerUnit;
	}

	public String getProductOrderCode() {
		return productOrderCode;
	}

	public void setProductOrderCode(String productOrderCode) {
		this.productOrderCode = productOrderCode;
	}

	public float getProductCostPerUnit() {
		return productCostPerUnit;
	}

	public void setProductCostPerUnit(float productCostPerUnit) {
		this.productCostPerUnit = productCostPerUnit;
	}

	public Long getProductCode() {
		return productCode;
	}

	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

}
