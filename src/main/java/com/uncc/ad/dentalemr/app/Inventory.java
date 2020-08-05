package com.uncc.ad.dentalemr.app;

public class Inventory {

	private int invid;
	private int medid;
	private int stock;

	public int getInvid() {
		return invid;
	}

	public void setInvid(int invid) {
		this.invid = invid;
	}

	public int getMedid() {
		return medid;
	}

	public void setMedid(int medid) {
		this.medid = medid;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Inventory(int invid, int medid, int stock) {
		super();
		this.invid = invid;
		this.medid = medid;
		this.stock = stock;
	}

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Inventory [invid=" + invid + ", medid=" + medid + ", stock=" + stock + "]";
	}
	
}