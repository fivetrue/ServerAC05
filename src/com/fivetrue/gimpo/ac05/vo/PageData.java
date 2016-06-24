package com.fivetrue.gimpo.ac05.vo;


import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.AutoIncrement;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class PageData extends DatabaseObject{
	
	public static enum PageType{
		None,
		Notice,
		Town,
		Journal,
		News,
	}
	
	public PageData(){
		
	}
	
	public PageData(String pageTitle, String pageUrl, String titleColor, String titleBgColor
			, String contentColor, String contentBgColor, String contentDescription, String pageType){
		this.pageTitle = pageTitle;
		this.pageUrl = pageUrl;
		this.titleColor = titleColor;
		this.titleBgColor = titleBgColor;
		this.contentColor = contentColor;
		this.contentBgColor = contentBgColor;
		this.contentDescription = contentDescription;
		this.pageType = pageType;
	}
	
	@PrimaryKey
	@AutoIncrement
	private int pageId = 0;
	
	private String pageTitle = null;
	
	@StringLength(256)
	private String pageUrl = null;
	
	private String titleColor = null;
	private String titleBgColor = null;
	
	private String contentColor = null;
	private String contentBgColor = null;
	
	private String contentDescription = null;
	
	@StringLength(24)
	private String pageType = "None";

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
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

	public String getContentDescription() {
		return contentDescription;
	}

	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	@Override
	public String toString() {
		return "PageData [pageId=" + pageId + ", pageTitle=" + pageTitle + ", pageUrl=" + pageUrl + ", titleColor="
				+ titleColor + ", titleBgColor=" + titleBgColor + ", contentColor=" + contentColor + ", contentBgColor="
				+ contentBgColor + ", contentDescription=" + contentDescription + ", pageType=" + pageType
				+ "]";
	}
	
}
