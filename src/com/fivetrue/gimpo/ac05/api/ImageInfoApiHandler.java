package com.fivetrue.gimpo.ac05.api;



import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.db.DBMessage;
import com.fivetrue.db.annotation.AutoIncrement;
import com.fivetrue.gimpo.ac05.manager.AdminUserDBManager;
import com.fivetrue.gimpo.ac05.manager.ImageInfoDBManager;
import com.fivetrue.gimpo.ac05.manager.NotificationDataDBManager;
import com.fivetrue.gimpo.ac05.manager.UserDBManager;
import com.fivetrue.gimpo.ac05.vo.ImageInfo;
import com.fivetrue.gimpo.ac05.vo.NotificationData;
import com.fivetrue.utils.TextUtils;


public class ImageInfoApiHandler extends ProjectCheckApiHandler{


	private static final String TAG = "ImageInfoApiHandler";

	public ImageInfoApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
	}
	
	
	public void getImageInfo(){
		if(checkRequestValidation()){
			String type = getParameter("type");
			String where = null;
			Result result = new Result();
			
			if(type != null){
				where = "imageType='"+ type + "'";
			}
			String query = ImageInfoDBManager.getInstance().getSelectQuery(null, where);
			query += " ORDER BY `imageType`, `index`";
			ArrayList<ImageInfo> imageInfos = ImageInfoDBManager.getInstance().rawQuery(query);
			result.makeResponseTime();
			result.setErrorCode(Result.ERROR_CODE_OK);
			result.setResult(imageInfos);
			writeObject(result);
		}
	}
	
	public void deleteImageInfo(){
		if(checkRequestValidation()){
			writeObject(deleteImageInfoResult());
		}	
	}
	
	public Result deleteImageInfoResult(){
		Result result = new Result();
		String id = getParameter("id");
		String userEmail = getParameter("email");
		if(TextUtils.isEmpty(id) || TextUtils.isEmpty(userEmail)){
			result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
			result.setMessage("AdminEmail정보가 없습니다. Id 정보가 없습니다.");
		}else{
			int count = UserDBManager.getInstance().getCountData("email='" + userEmail + "'");
			if(count > 0){
				ArrayList<ImageInfo> data = ImageInfoDBManager.getInstance().getSelectQueryData(null, "imageInfoId=" + id);
				if(data != null && data.size() > 0){
					DBMessage msg = ImageInfoDBManager.getInstance().removeObject(data.get(0));
					result.setResult(msg);
					result.setErrorCode(Result.ERROR_CODE_OK);
				}
			}else{ 
				result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
				result.setMessage("AdminEmail정보가 없습니다.");
			}
		}
		result.makeResponseTime();
		return result;
	}
	
	
	public void updateImageInfo(){
		if(checkRequestValidation()){
			writeObject(updateImageInfoResult());
		}
	}
	
	public Result updateImageInfoResult(){
		Result result = new Result();
		ImageInfo info = new ImageInfo();
		for(Field f : ImageInfo.class.getDeclaredFields()){
			f.setAccessible(true);
			String value = getParameter(f.getName());
			try {
				if(f.getType().getSimpleName().equalsIgnoreCase("string")){
					f.set(info, value);
				}else{
					f.setInt(info, Integer.valueOf(value));
				}
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
		}
		
		String userEmail = getParameter("email");
		if(TextUtils.isEmpty(userEmail)){
			result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
			result.setMessage("AdminEmail정보가 없습니다.");
		}else{
			int count = UserDBManager.getInstance().getCountData("email='" + userEmail + "'");
			if(count > 0){
				DBMessage message = ImageInfoDBManager.getInstance().updateObject(info);
				result.setResult(message);
			}else{
				result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
				result.setMessage("AdminEmail정보가 없습니다.");
			}
		}
		result.makeResponseTime();
		return result;
	}
	
	public void addImageInfo(){
		if(checkRequestValidation()){
			writeObject(addImageInfoResult());
		}
	}
	
	public Result addImageInfoResult(){
		Result result = new Result();
		ImageInfo info = new ImageInfo();
		for(Field f : ImageInfo.class.getDeclaredFields()){
			f.setAccessible(true);
			if(f.getAnnotation(AutoIncrement.class) != null){
				continue;
			}
			String value = getParameter(f.getName());
			try {
				if(f.getType().getSimpleName().equalsIgnoreCase("string")){
					f.set(info, value);
				}else{
					f.setInt(info, Integer.valueOf(value));
				}
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
		}
		
		String userEmail = getParameter("email");
		if(TextUtils.isEmpty(userEmail)){
			result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
			result.setMessage("AdminEmail정보가 없습니다.");
		}else{
			int count = UserDBManager.getInstance().getCountData("email='" + userEmail + "'");
			if(count > 0){
				DBMessage message = ImageInfoDBManager.getInstance().insertObject(info);
				result.setResult(message);
			}else{
				result.setErrorCode(Result.ERROR_CODE_REQUEST_ERROR);
				result.setMessage("AdminEmail정보가 없습니다.");
			}
		}
		result.makeResponseTime();
		return result;
	}
}
