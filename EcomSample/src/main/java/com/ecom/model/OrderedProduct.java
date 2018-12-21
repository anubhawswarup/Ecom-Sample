package com.ecom.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderedProduct {

	@JsonProperty("product")
	private String productName;

	@JsonProperty("quantity")
	private Double quantity;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
