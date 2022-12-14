package com.pharmacy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class Inventory {
	
	@Id
	@Column(name="drugID" , nullable = false)
	private Long drugID;
	
	@Column(name="drugName", nullable = false)
	private String drugName;
	
	@Column(name ="drugQuantity", nullable = true)
	private int drugQuantity;
	
	@Column(name = "drugPrice" ,nullable = true)
	private int drugPrice;
	
	public Inventory(Long drugID, String drugName, int drugQuantity, int drugPrice, String supplierName) {
		super();
		this.drugID = drugID;
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.drugPrice = drugPrice;
		this.supplierName = supplierName;
	}

	public int getDrugPrice() {
		return drugPrice;
	}

	public void setDrugPrice(int drugPrice) {
		this.drugPrice = drugPrice;
	}

	@Column(name ="supplierName", nullable = false)
	private String supplierName;

	public Inventory() {
		super();
	}

	public Inventory(String drugName, int drugQuantity, String supplierName) {
		super();
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.supplierName = supplierName;
	}

	public Inventory(Long drugID, String drugName, int drugQuantity, String supplierName) {
		super();
		this.drugID = drugID;
		this.drugName = drugName;
		this.drugQuantity = drugQuantity;
		this.supplierName = supplierName;
	}

	public Long getDrugID() {
		return drugID;
	}

	public void setDrugID(Long drugID) {
		this.drugID = drugID;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public int getDrugQuantity() {
		return drugQuantity;
	}

	public void setDrugQuantity(int drugQuantity) {
		this.drugQuantity = drugQuantity;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public String toString() {
		return "Inventory [drugID=" + drugID + ", drugName=" + drugName + ", drugQuantity=" + drugQuantity
				+ ", drugPrice=" + drugPrice + ", supplierName=" + supplierName + "]";
	}
}
