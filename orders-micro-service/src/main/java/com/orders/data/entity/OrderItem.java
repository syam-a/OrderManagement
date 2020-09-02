package com.orders.data.entity;


public class OrderItem {

	
	private Long productCode;

	
	private String productName;

	
	private int productQuantity;
	
	private Long productOrderCode;
	
	private float productPricePerUnit;

	public OrderItem() {

	}

	

	public OrderItem(Long productCode, String productName, int productQuantity, Long productOrderCode,
			float productPricePerUnit) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productOrderCode = productOrderCode;
		this.productPricePerUnit = productPricePerUnit;
	}



	public Long getProductOrderCode() {
		return productOrderCode;
	}



	public void setProductOrderCode(Long productOrderCode) {
		this.productOrderCode = productOrderCode;
	}



	public float getProductPricePerUnit() {
		return productPricePerUnit;
	}



	public void setProductPricePerUnit(float productPricePerUnit) {
		this.productPricePerUnit = productPricePerUnit;
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
