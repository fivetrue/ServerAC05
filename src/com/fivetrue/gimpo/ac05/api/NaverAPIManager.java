package com.fivetrue.gimpo.ac05.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.gimpo.ac05.NaverConstants;
import com.fivetrue.gimpo.ac05.vo.AuthLoginResult;
import com.fivetrue.gimpo.ac05.vo.UserInfo;

import javafx.util.Pair;

public class NaverAPIManager extends ProjectCheckApiHandler{
	
	private static final String TAG = "NaverAPIManager";

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

		String respose = requestApi(NaverConstants.Cafe.SIGNUP_CAFE_API, "POST", 
				token,
				new Pair<String, String>("clubid", NaverConstants.Cafe.CAFE_ID), 
				new Pair<String, String>("nickname", user.getNickname()));

		writeContent(respose);
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
	
	private String requestApi(String api, String method, String token, Pair<String, String>...parameters){
		String response = "";
		try {
			boolean hasoutbody = method.equalsIgnoreCase("POST");
            final URL url = new URL(api);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.addRequestProperty(NaverConstants.HEADER_KEY_X_NAVER_CLIENT_ID, NaverConstants.CLIENT_ID);
            conn.addRequestProperty(NaverConstants.HEADER_KEY_X_NAVER_CLIENT_SECRET, NaverConstants.CLIENT_SECRET);
            if(token != null){
            	conn.addRequestProperty(NaverConstants.HEADER_KEY_AUTHORIZATION, "Bearer " + token);
            }

            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(hasoutbody);
            conn.connect();
            
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(parameters));

            writer.flush();
            writer.close();
            os.close();
            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }
            else {
                response="";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		getContext().log(TAG + " : requestAPi ("
				+ "api = " + api + " / "
				+ "method = " + method + " / "
				+ "parameter = " + parameters != null ? parameters.toString() : "" + " / "
				+ "response = " + response + " / "
				+ ")" );
		
		return response;
	}
	
	private String getPostDataString(Pair<String, String>[] pairs){
		String data = "";
		if(pairs != null && pairs.length > 0){
			for(Pair<String, String> p : pairs){
				data += p.getKey() + "=" + p.getValue() + "&"; 
			}
		}
		return data;
		
	}

}
