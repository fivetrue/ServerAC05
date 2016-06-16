package com.fivetrue.gimpo.ac05.vo;

import java.util.ArrayList;

public class PageDataEntry {
	
	private String dataTitle = null;
	private int count = 0;
	private String titleColor = null;
	private String titleBgColor = null;
	
	private String contentColor = null;
	private String contentBgColor = null;
	
	private ArrayList<PageData> pages = new ArrayList<>();
	public String getDataTitle() {
		return dataTitle;
	}
	public void setDataTitle(String dataTitle) {
		this.dataTitle = dataTitle;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public ArrayList<PageData> getPages() {
		return pages;
	}
	
	public void setPages(ArrayList<PageData> pages) {
		this.pages = pages;
	}
	@Override
	public String toString() {
		return "PageDataEntry [dataTitle=" + dataTitle + ", count=" + count + ", titleColor=" + titleColor
				+ ", titleBgColor=" + titleBgColor + ", contentColor=" + contentColor + ", contentBgColor="
				+ contentBgColor + ", pages=" + pages + "]";
	}

}
