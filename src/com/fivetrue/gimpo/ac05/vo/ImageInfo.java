package com.fivetrue.gimpo.ac05.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.AutoIncrement;
import com.fivetrue.db.annotation.DisplayName;
import com.fivetrue.db.annotation.PrimaryKey;

public class ImageInfo extends DatabaseObject{
	
	@PrimaryKey
	@AutoIncrement
	@DisplayName("아이디")
	private int imageInfoId = 0;
	
	@DisplayName("이미지 URL")
	private String imageUrl = null;
	@DisplayName("이미지 이름")
	private String imageName = null;
	@DisplayName("설명")
	private String description = null;
	@DisplayName("타입")
	private String imageType = null;
	@DisplayName("INDEX")
	private int index = 0;
	
	public ImageInfo(){
		
	}
	
	public ImageInfo(String url, String name, String desc, String type){
		this.imageUrl = url;
		this.imageName = name;
		this.description = desc;
		this.imageType = type;
	}
	
	public int getImageInfoId() {
		return imageInfoId;
	}

	public void setImageInfoId(int imageInfoId) {
		this.imageInfoId = imageInfoId;
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
