package com.fivetrue.gimpo.ac05.api;


import java.lang.reflect.Field;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.db.DBMessage;
import com.fivetrue.gimpo.ac05.manager.UserDBManager;
import com.fivetrue.gimpo.ac05.vo.UserInfo;
import com.fivetrue.utils.TextUtils;


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
				String typeName = f.getType().getSimpleName();
				String value = getParameter(f.getName());
				try {
					if(typeName.contains("Integer") || typeName.contains("int")){
						f.setInt(user, Integer.parseInt(value));
					}else{
						f.set(user, value);
					}
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
			UserInfo existUser = UserDBManager.getInstance().isExistUser(user);
			if(existUser != null){
				user.setDistrict(existUser.getDistrict());
				msg = UserDBManager.getInstance().updateObject(user);
			}else{
//				UserDBManager.getInstance().create();
				msg = UserDBManager.getInstance().insertObject(user);
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
