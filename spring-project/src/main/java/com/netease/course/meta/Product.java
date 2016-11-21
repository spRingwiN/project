package com.netease.course.meta;

public class Product {
	private int id;
	private String title;
	private String summary;
	private String detail;
	private String image;
	private long dbPrice;
	private double price;
	private double buyPrice;
	private byte[] icon;
	private byte[] text;
	private Boolean isBuy=false;
	private Boolean isSell=false;
	public void buy(){
		isBuy=true;
		isSell=true;
	}
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getIsBuy() {
		return isBuy;
	}
	public void setIsBuy(Boolean isBuy) {
		this.isBuy = isBuy;
	}
	public Boolean getIsSell() {
		return isSell;
	}
	public void setIsSell(Boolean isSell) {
		this.isSell = isSell;
	}
	public byte[] getIcon() {
		return icon;
	}
	public void setIcon(byte[] icon) {
		this.icon = icon;
	}
	public byte[] getText() {
		return text;
	}
	public void setText(byte[] text) {
		this.text = text;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
