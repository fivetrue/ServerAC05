package com.fivetrue.gimpo.ac05.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.gimpo.ac05.NaverConstants;
import com.fivetrue.gimpo.ac05.vo.AuthLoginResult;
import com.fivetrue.gimpo.ac05.vo.UserInfo;

import javafx.util.Pair;

public class NaverAPIManager extends ProjectCheckApiHandler{
	
	public NaverAPIManager(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
//		checkRequestValidation();
	}
	
	
	public void requestLogin(){
//		https://nid.naver.com/oauth2.0/authorize?client_id={클라이언트 아이디}&response_type=code&redirect_uri={개발자 센터에 등록한 콜백 URL(URL 인코딩)}&state={상태 토큰}
		String state = getParameter("state");
		if(state != null){
			String redirectUrl = NaverConstants.Login.REDIRECT_CALLBACK_URL;
			try {
				redirectUrl = URLEncoder.encode(NaverConstants.Login.REDIRECT_CALLBACK_URL, "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String api = String.format(NaverConstants.Login.LOGIN_AUTH_API, redirectUrl, state);
			try {
				getResponse().sendRedirect(api);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			Result result = new Result();
			result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
			result.setMessage("parameter state is null");
			result.makeResponseTime();
			writeObject(result);
		}
	}
	
	public AuthLoginResult receiveServiceCallback(){
		
		AuthLoginResult loginResult = new AuthLoginResult();
		Field[] fields = loginResult.getClass().getDeclaredFields();
		for(Field f : fields){
			f.setAccessible(true);
			String value = getParameter(f.getName());
			try {
				f.set(loginResult, value);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getContext().log("check callback Parameter : " + loginResult.toString());
		return loginResult;
	}
	
	public void requestSignup() throws IOException{
		
		UserInfo user = new UserInfo();
		Field[] fields = user.getClass().getDeclaredFields();
		
		for(Field f : fields){
			f.setAccessible(true);
			String value = getRequest().getParameter(f.getName());
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
		String token = getParameter("token");

//		String respose = requestApi(String.format(NaverConstants.Cafe.SIGNUP_CAFE_API, NaverConstants.Cafe.CAFE_ID), "POST", 
//				token,
//				new Pair<String, String>("clubid", NaverConstants.Cafe.CAFE_ID), 
//				new Pair<String, String>("nickname", user.getNickname()));
//
//		writeContent(respose);
	}
	
	public void requestToken(){
		checkRequestValidation();
		Result result = new Result();
		Pair<String, String>[] pairs = new Pair[getRequest().getParameterMap().size()];
		int count = 0 ;
		for(String key : getRequest().getParameterMap().keySet()){
			pairs[count ++] = new Pair<String, String>(key, getRequest().getParameter(key));
		}
		String response = requestApi(NaverConstants.Login.AUTH_TOKEN_API, "POST", false, null, pairs);
		
		result.setErrorCode(Result.ERROR_CODE_OK);
		result.setResult(response);
		result.makeResponseTime();
		writeObject(result);
	}
	
	public void requestLoginAuth(){
//		https://nid.naver.com/oauth2.0/authorize?client_id={클라이언트 아이디}&response_type=code&redirect_uri={개발자 센터에 등록한 콜백 URL(URL 인코딩)}&state={상태 토큰}
//		String state = getRequest().getParameter("state");
//		if(state != null){
//			String response = requestApi(NaverConstants.Login.LOGIN_AUTH_API, "POST", 
//					new Pair<String, String>("client_id", NaverConstants.CLIENT_ID),
//					new Pair<String, String>("response_type", "code"),
//					new Pair<String, String>("redirect_uri", NaverConstants.Login.REDIRECT_CALLBACK_URL),
//					new Pair<String, String>("stat", state));
//			
//			
//		}
		
	}

}
