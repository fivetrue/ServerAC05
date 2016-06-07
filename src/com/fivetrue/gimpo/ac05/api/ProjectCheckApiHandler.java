package com.fivetrue.gimpo.ac05.api;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.BaseApiHandler;
import com.fivetrue.api.Result;
import com.fivetrue.gimpo.ac05.Constants;
import com.google.gson.Gson;


abstract public class ProjectCheckApiHandler extends BaseApiHandler{

	public ProjectCheckApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean checkRequestValidation() {
		// TODO Auto-generated method stub
		String appId = getRequest().getHeader(Constants.KEY_APP_ID);
		String appKey = getRequest().getHeader(Constants.KEY_APP_KEY);
		Date date = new Date(System.currentTimeMillis());
		String log = getSimpleDataFormat().format(date) + " / RemoteAddr : (" + getRequest().getRemoteAddr()  + ") / "
				+"Headers : (" + "ContentType : " + getRequest().getContentType() + ", "
				+ Constants.KEY_APP_ID + " : " + appId + ", "
				+ Constants.KEY_APP_KEY + " : " + appKey + ") / ";
		log += "Path : (" + getRequest().getServletPath() + ") / "; 		
		log += "Class : (" + getClass().getName() + ") / "; 		
		log += "Parameters : (";
		for(String key : getRequest().getParameterMap().keySet()){
			log += key + " : " + getRequest().getParameter(key) + ", ";
		}
		getContext().log(log);
//		System.out.println(log );
		boolean b = appId != null && appId.equals(Constants.APP_ID) && appKey != null && appKey.equals(Constants.APP_KEY);
		if(!b){
			Result result = new Result();
			result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
			result.setMessage("Invalid header values");
			result.makeResponseTime();
			writeObject(result);
		}
		return b;
	}
	
	
	protected void writeObject(Object obj){
		if(obj != null){
			writeContent(new Gson().toJson(obj));
		}
	}

}
