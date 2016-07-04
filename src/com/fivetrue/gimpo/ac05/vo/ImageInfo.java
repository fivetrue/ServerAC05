package com.fivetrue.gimpo.ac05.vo;

import com.fivetrue.db.DatabaseObject;

public class ImageInfo extends DatabaseObject{
	
	private String imageUrl = null;
	private String imageName = null;
	private String description = null;
	private String imageType = null;
	private int index = 0;
	
	public ImageInfo(String url, String name, String desc, String type){
		this.imageUrl = url;
		this.imageName = name;
		this.description = desc;
		this.imageType = type;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "ImageInfo [imageUrl=" + imageUrl + ", imageName=" + imageName + ", description=" + description
				+ ", imageType=" + imageType + ", index=" + index + "]";
	}
}
