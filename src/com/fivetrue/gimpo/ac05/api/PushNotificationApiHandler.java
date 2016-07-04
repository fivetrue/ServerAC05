package com.fivetrue.gimpo.ac05.api;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.manager.NotificationDataCheckUserDBManager;
import com.fivetrue.gimpo.ac05.vo.NotificationData;
import com.fivetrue.gimpo.ac05.vo.NotificationDataCheckUser;
import com.fivetrue.gimpo.ac05.vo.PushMessage;
import com.fivetrue.utils.TextUtils;
import com.google.gson.Gson;

import javafx.util.Pair;

public class PushNotificationApiHandler extends ProjectCheckApiHandler{

	public PushNotificationApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
	}
	
	public void sendNotificationToUser(){
		Result result = new Result(); 
		result.setErrorCode(Result.ERROR_CODE_OK);
		PushMessage message = new PushMessage();
		String response = sendNotification(message);
		result.setResult(response);
		writeObject(result);
	}
	
	public NotificationData getNotificationDataFromParameter(){
		NotificationData data = new NotificationData();
		Field[] fields = data.getClass().getDeclaredFields();
		for(Field f : fields){
			f.setAccessible(true);
			String typeName = f.getType().toString();
			String value = getParameter(f.getName());
			if(value != null){
				try {
					Object obj = null;
					if(typeName.contains("Integer") || typeName.contains("int")){
						try{
							obj = Integer.parseInt(value);
						}catch(NumberFormatException e){
							e.printStackTrace();
							obj = 1;
						}
					}else{
						obj = value;
					}
					f.set(data, obj);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	
	public void checkPush(){
		String redirect = getParameter("redirect");
		String id = getParameter("id");
		String email = getParameter("email");
		
		if(!TextUtils.isEmpty(id) && !TextUtils.isEmpty(email)){
			int count = NotificationDataCheckUserDBManager.getInstance().getCountData("notiMulticastId='" + id + "' AND userEmail='"+ email + "'");
			if(count == 0){
				NotificationDataCheckUser data = new NotificationDataCheckUser();
				data.setNotiMulticastId(id);
				data.setUserEmail(email);
				NotificationDataCheckUserDBManager.getInstance().insertObject(data);
			}
		}
		
		
		
		try {
			getResponse().sendRedirect(redirect);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public static String sendNotification(PushMessage message){
		Pair<String,String>[] headers = new Pair[2]; 
		headers[0] = new Pair<String, String>("Authorization", "key=" + Constants.GCM.GCM_KEY);
		headers[1] = new Pair<String, String>("Content-Type", "application/json");
		System.out.println(message.toString());
		String push = new Gson().toJson(message);
		System.out.println("Push_message = " + push);
		String response = requestApi(Constants.GCM.GCM_SEND_SERVER_URL, "POST", false, headers, push);
		System.out.println("response = " + response);
		return response;
	}
	
}
