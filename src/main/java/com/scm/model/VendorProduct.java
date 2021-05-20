package com.scm.model;

public class VendorProduct {
	private int ProductID;
	private String ProductName;
	private String ProductPrice;;
	private int Quantity;
	private int VendorID;
	public int getVendorID() {
		return VendorID;
	}

	public void setVendorID(int vendorID) {
		VendorID = vendorID;
	}

	public VendorProduct(int productID, String productName, String productPrice, int quantity) {
		super();
		ProductID = productID;
		ProductName = productName;
		ProductPrice = productPrice;
		Quantity = quantity;
	}
	public VendorProduct(int vendorID, int productID, int quantity) {
		super();
		VendorID = vendorID;
		ProductID = productID;
		Quantity = quantity;
	}
	public VendorProduct(int quantity,int productID) {
		super();
		Quantity = quantity;
		ProductID = productID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(String productPrice) {
		ProductPrice = productPrice;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "VendorProduct [ProductID=" + ProductID + ", ProductName=" + ProductName + ", ProductPrice="
				+ ProductPrice + ", Quantity=" + Quantity + ", VendorID=" + VendorID + "]";
	}
	
	
}
