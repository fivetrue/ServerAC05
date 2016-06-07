package com.fivetrue.gimpo.ac05.api;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.NaverConstants;
import com.fivetrue.gimpo.ac05.vo.AppConfig;



public class ConfigApiHandler extends ProjectCheckApiHandler{


	public ConfigApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
	}

	public void getAppConfig(){
		if(checkRequestValidation()){
			Result result = new Result();
			result.setErrorCode(Result.ERROR_CODE_OK);
			AppConfig config = new AppConfig();
			config.appId = Constants.APP_ID;
			config.appLatestVersion = Constants.APP_LATEST_VERSION;
			config.appVersionName = Constants.APP_VERSION_NAME;
			config.appMarketUrl = Constants.APP_MARKET_URL;
			config.senderId = Constants.GCM.GCM_SENDER_ID;
			config.naverClientId = NaverConstants.CLIENT_ID;
			config.naverClientSecret = NaverConstants.CLIENT_SECRET;
			result.setResult(config);
			writeObject(result);
		}
	}
}