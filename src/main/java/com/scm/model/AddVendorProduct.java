package com.scm.model;

public class AddVendorProduct {
	private int VendorID;
	private int ProductID;
	private int Qunatity;
	public AddVendorProduct(int vendorID, int productID, int qunatity) {
		super();
		VendorID = vendorID;
		ProductID = productID;
		Qunatity = qunatity;
	}
	public int getVendorID() {
		return VendorID;
	}
	public void setVendorID(int vendorID) {
		VendorID = vendorID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public int getQunatity() {
		return Qunatity;
	}
	public void setQunatity(int qunatity) {
		Qunatity = qunatity;
	}
	@Override
	public String toString() {
		return "AddVendorProduct [VendorID=" + VendorID + ", ProductID=" + ProductID + ", Qunatity=" + Qunatity + "]";
	}
	
}
