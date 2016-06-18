package com.fivetrue.gimpo.ac05.vo;

import java.util.ArrayList;

public class PushMessage {
	
	private ArrayList<String> registration_ids = new ArrayList<>();
	private Data data = new Data();
	public ArrayList<String> getRegistration_ids() {
		return registration_ids;
	}
	public void setRegistration_ids(ArrayList<String> registration_ids) {
		this.registration_ids = registration_ids;
	}
	public Object getData() {
		return data;
	}
	public void setData(NotificationData data) {
		this.data.data = data;
	}
	
	protected static final class Data{
		private Object data = null;
	}
	@Override
	public String toString() {
		return "PushMessage [registration_ids=" + registration_ids + ", data=" + data + "]";
	}
	
}
