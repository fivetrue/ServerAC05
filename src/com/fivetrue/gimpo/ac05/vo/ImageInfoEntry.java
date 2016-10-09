package com.fivetrue.gimpo.ac05.vo;

import java.util.ArrayList;

public class ImageInfoEntry {

	private String title = null;
	private String content = null;
	private ArrayList<ImageInfo> imageInfos = null;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ArrayList<ImageInfo> getImageInfos() {
		return imageInfos;
	}
	public void setImageInfos(ArrayList<ImageInfo> imageInfos) {
		this.imageInfos = imageInfos;
	}
	@Override
	public String toString() {
		return "ImageInfoEntry [title=" + title + ", content=" + content + ", imageInfos=" + imageInfos + "]";
	}
	
}