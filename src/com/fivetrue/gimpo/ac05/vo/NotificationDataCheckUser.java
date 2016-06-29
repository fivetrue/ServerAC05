package com.fivetrue.gimpo.ac05.vo;

import com.fivetrue.db.DatabaseObject;

public class NotificationDataCheckUser extends DatabaseObject{
	
	private String notiMulticastId = null;
	private String userEmail = null;
	public String getNotiMulticastId() {
		return notiMulticastId;
	}
	public void setNotiMulticastId(String notiMulticastId) {
		this.notiMulticastId = notiMulticastId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "NotificationDataCheckUser [notiMulticastId=" + notiMulticastId + ", userEmail=" + userEmail + "]";
	}

}
