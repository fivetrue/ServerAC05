package com.fivetrue.gimpo.ac05.api;


import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.NaverConstants;
import com.fivetrue.gimpo.ac05.manager.AppConfigDBManager;
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
			AppConfigDBManager.getInstance().create();
			String query = AppConfigDBManager.getInstance().getSelectQuery(null, null);
			query += " ORDER BY appVersionCode DESC";
			
			AppConfig config = null;
			ArrayList<AppConfig> configs = AppConfigDBManager.getInstance().rawQuery(query);
			if(configs != null && configs.size() > 0){
				config = configs.get(0);
			}
			result.setResult(config);
			writeObject(result);
		}
	}
}
