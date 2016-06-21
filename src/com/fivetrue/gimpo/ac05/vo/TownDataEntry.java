package com.fivetrue.gimpo.ac05.vo;

import java.util.ArrayList;

public class TownDataEntry {
	
	private int count = 0;
	private String description = null;
	private String title = null;
	private String titleColor = null;
	private String titleBgColor = null;
	private String contentColor = null;
	private String contentBgColor = null;
	private ArrayList<TownData> list = new ArrayList<>();
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitleColor() {
		return titleColor;
	}
	public void setTitleColor(String titleColor) {
		this.titleColor = titleColor;
	}
	public String getTitleBgColor() {
		return titleBgColor;
	}
	public void setTitleBgColor(String titleBgColor) {
		this.titleBgColor = titleBgColor;
	}
	public String getContentColor() {
		return contentColor;
	}
	public void setContentColor(String contentColor) {
		this.contentColor = contentColor;
	}
	public String getContentBgColor() {
		return contentBgColor;
	}
	public void setContentBgColor(String contentBgColor) {
		this.contentBgColor = contentBgColor;
	}
	public ArrayList<TownData> getList() {
		return list;
	}
	public void setList(ArrayList<TownData> list) {
		this.list = list;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
