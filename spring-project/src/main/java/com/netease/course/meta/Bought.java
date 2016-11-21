package com.netease.course.meta;

public class Bought {
	private int id;
	private String title;
	private String image;
	private byte[] icon;
	private double buyPrice;
	private long dbPrice;
	private long buyTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(long buyTime) {
		this.buyTime = buyTime;
	}
	public byte[] getIcon() {
		return icon;
	}
	public void setIcon(byte[] icon) {
		this.icon = icon;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public long getDbPrice() {
		return dbPrice;
	}
	public void setDbPrice(long dbPrice) {
		this.dbPrice = dbPrice;
	}


	

}
