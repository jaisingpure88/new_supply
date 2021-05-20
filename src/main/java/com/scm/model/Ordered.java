package com.scm.model;

public class Ordered {
	private int productID;
	private String productName;
	private String userName;
	private int totalPrice;
	private String orderDate;
	private String deliveryDate;
	private int userID;
	private int quantity;
	private int Ordered;
	
	public Ordered(int productID, String productName, String userName, int totalPrice, String orderDate,
			String deliveryDate) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.userName = userName;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
	}
	

	public Ordered( int userID,int productID,int quantity, int totalPrice,int ordered, String orderDate, String deliveryDate) {
		super();
		this.productID = productID;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.userID = userID;
		this.quantity = quantity;
		this.Ordered = ordered;
	}


	public int getOrdered() {
		return Ordered;
	}


	public void setOrdered(int ordered) {
		Ordered = ordered;
	}


	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	@Override
	public String toString() {
		return "Ordered [productID=" + productID + ", productName=" + productName + ", userName=" + userName
				+ ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate
				+ ", userID=" + userID + ", quantity=" + quantity + ", Ordered=" + Ordered + "]";
	}
	



	
}
