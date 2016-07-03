package com.fivetrue.gimpo.ac05.api;


import java.util.ArrayList;

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
			config.clubId = NaverConstants.Cafe.CAFE_ID;
			config.clubUrl = NaverConstants.Cafe.CAFE_URL;
			config.clubMyInfo = NaverConstants.Cafe.CAFE_USER_INFO_URL;
			config.myInfoUrl = NaverConstants.User.MY_INFO_URL;
			
			ArrayList<String> districtList = new ArrayList<>();
			for(int i = 0 ; i < 15 ; i ++){
				int value = i + 1;
				districtList.add("5" + (value < 10 ? "0"+value : value));
			}
			config.districtList = districtList;
			
			ArrayList<String> infomationUrlList = new ArrayList<>();
			infomationUrlList.add("/image/main_visual.jpg");
			infomationUrlList.add("/image/img_type1.jpg");
			infomationUrlList.add("/image/img_type2.jpg");
			infomationUrlList.add("/image/img_type3.jpg");
			infomationUrlList.add("/image/img_type4.jpg");
			infomationUrlList.add("/image/img_interior1.jpg");
			infomationUrlList.add("/image/img_interior2.jpg");
			infomationUrlList.add("/image/img_interior3.jpg");
			infomationUrlList.add("/image/img_interior4.jpg");
			infomationUrlList.add("/image/img_material.jpg");
			
			config.infomationImageUrlList = infomationUrlList;
			result.setResult(config);
			writeObject(result);
		}
	}
	
	
}
