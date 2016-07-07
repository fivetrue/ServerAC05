package com.fivetrue.gimpo.ac05.api;


import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.db.DBMessage;
import com.fivetrue.gimpo.ac05.manager.DistrictDBManager;
import com.fivetrue.gimpo.ac05.vo.District;

public class DistrictApiHandler extends ProjectCheckApiHandler{


	public DistrictApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
	}

	public void getDistricts(){
		if(checkRequestValidation()){
			Result result = new Result();
			result.setErrorCode(Result.ERROR_CODE_OK);
			String query = DistrictDBManager.getInstance().getSelectQuery(null, null);
			query += " ORDER BY districtNumber";
			ArrayList<District> district = DistrictDBManager.getInstance().rawQuery(query);
			result.setResult(district);
			writeObject(result);
		}
	}

	public void updateDistrict(){
		if(checkRequestValidation()){
			writeObject(updateDistrictResult());
		}
	}

	public Result updateDistrictResult(){
		Result result = new Result();
		District config = new District();
		try {
			for(Field f : District.class.getDeclaredFields()){
				f.setAccessible(true);
				String value = getParameter(f.getName());
				if(f.getType() == String.class){
					f.set(config, value);
				}else{
					f.setInt(config, Integer.parseInt(value));
				}
			}
			DBMessage msg =  DistrictDBManager.getInstance().updateObject(config);
			result.setResult(msg);
			result.setErrorCode(Result.ERROR_CODE_OK);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
		}
		result.makeResponseTime();
		return result;
	}
	
	public void addDistrict(){
		if(checkRequestValidation()){
			writeObject(addDistrictResult());
		}
	}

	public Result addDistrictResult(){
		Result result = new Result();
		District config = new District();
		try {
			for(Field f : District.class.getDeclaredFields()){
				f.setAccessible(true);
				String value = getParameter(f.getName());
				if(f.getType() == String.class){
					f.set(config, value);
				}else{
					f.setInt(config, Integer.parseInt(value));
				}
			}
			DBMessage msg =  DistrictDBManager.getInstance().insertObject(config);
			result.setResult(msg);
			result.setErrorCode(Result.ERROR_CODE_OK);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
		}
		result.makeResponseTime();
		return result;
	}
}
