package com.fivetrue.gimpo.ac05.vo;

import java.util.Base64;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.StringLength;

public class PageData extends DatabaseObject{
	
	public static enum PageType{
		None,
		Town,
		Journal,
		News,
	}
	
	private String pageTitle = null;
	private String pageUrl = null;
	
	@StringLength(1024*8)
	private String pageContent = null;
	private String pageAuthor = null;
	
	@StringLength(24)
	private String pageType = "None";
	
	public String getPageTitle() {
		return new String(Base64.getDecoder().decode(pageTitle.getBytes()));
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = Base64.getEncoder().encodeToString(pageTitle.getBytes());;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	
	public String getPageContent() {
		return new String(Base64.getDecoder().decode(pageContent.getBytes()));
	}
	public void setPageContent(String pageContent) {
		this.pageContent = Base64.getEncoder().encodeToString(pageContent.getBytes());
	}
	
	public String getPageAuthor() {
		return pageAuthor;
	}
	public void setPageAuthor(String pageAuthor) {
		this.pageAuthor = pageAuthor;
	}
	
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	
	public PageType getType(){
		return PageType.valueOf(pageType);
	}
	@Override
	public String toString() {
		return "PageData [pageTitle=" + pageTitle + ", pageUrl=" + pageUrl + ", pageContent=" + pageContent
				+ ", pageAuthor=" + pageAuthor + ", pageType=" + pageType + "]";
	}
	
}
