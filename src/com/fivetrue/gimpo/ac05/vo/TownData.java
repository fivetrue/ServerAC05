package com.fivetrue.gimpo.ac05.vo;


import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.AutoIncrement;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class TownData extends DatabaseObject{
	
	@AutoIncrement
	@PrimaryKey
	private int postId = 0;
	
	private String title = null;
	
	@StringLength(256)
	private String url = null;
	
	private String titleColor = null;
	private String titleBgColor = null;
	
	private String contentColor = null;
	private String contentBgColor = null;
	
	private String author = null;
	private String date = null;
	
	@StringLength(2048*5)
	private String content = null;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TownData [postId=" + postId + ", title=" + title + ", url=" + url + ", titleColor=" + titleColor
				+ ", titleBgColor=" + titleBgColor + ", contentColor=" + contentColor + ", contentBgColor="
				+ contentBgColor + ", content=" + content + "]";
	}
	
}
