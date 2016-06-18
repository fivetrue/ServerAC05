package com.fivetrue.gimpo.ac05.api;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.PushMessage;
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
