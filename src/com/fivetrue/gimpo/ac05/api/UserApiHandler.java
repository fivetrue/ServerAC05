package com.fivetrue.gimpo.ac05.api;


import java.lang.reflect.Field;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.db.DBMessage;
import com.fivetrue.gimpo.ac05.manager.UserDBManager;
import com.fivetrue.gimpo.ac05.vo.NotificationData;
import com.fivetrue.gimpo.ac05.vo.PushMessage;
import com.fivetrue.gimpo.ac05.vo.UserInfo;


public class UserApiHandler extends ProjectCheckApiHandler{

	/**
	 * 유저 errorcode 정보
	 * 2000 = 중복된 이메일
	 * 3000 = 중복된 닉네임
	 * 400 = 파라메터 에러
	 * 
	 */
	public static final String GCM = "gcm";

	public static final int ERROR_CODE_DUPLICATED_EMAIL = 2000;
	public static final int ERROR_CODE_DUPLICATED_NICKNAME = 2001;
	public static final int ERROR_CODE_INVALID_LOGIN_INFO = 2002;


	public UserApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
	}

	public void registerUser(){
		if(checkRequestValidation()){
			
			UserInfo user = new UserInfo();
			
			Field[] fds = user.getClass().getDeclaredFields();
			for(Field f : fds){
				f.setAccessible(true);
				String value = getParameter(f.getName());
				try {
					f.set(user, value);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			Result result = new Result();  
			DBMessage msg = null;
			if(UserDBManager.getInstance().isExistUser(user)){
				msg = UserDBManager.getInstance().updateObject(user);
//				PushMessage message = new PushMessage();
//				message.getRegistration_ids().add(user.getGcmId());
//				NotificationData data = new NotificationData();
//				data.id = 12;
//				data.title = "알림";
//				data.message = "유저 정보 갱신 성공";
//				message.setData(data);
//				PushNotificationApiHandler.sendNotification(message);
			}else{
				msg = UserDBManager.getInstance().insertObject(user);
				if(msg != null && msg.getMessage() != null){
					UserDBManager.getInstance().create();
				}
			}
			
			if(msg.getRow() > 0){
				result.setMessage(Result.OK_MESSAGE);
				result.setErrorCode(Result.ERROR_CODE_OK);
				result.setResult(user);	
			}else{
				result.setMessage(msg.getMessage());
				result.setErrorCode(Result.ERROR_CODE_DB_ERROR);
				result.setResult(user);
			}
			result.makeResponseTime();
			writeObject(result);
		}
	}
}
