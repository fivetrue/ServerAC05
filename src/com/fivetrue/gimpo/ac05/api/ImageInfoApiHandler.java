package com.fivetrue.gimpo.ac05.api;



import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;
import com.fivetrue.gimpo.ac05.manager.ImageInfoDBManager;
import com.fivetrue.gimpo.ac05.vo.ImageInfo;


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
			query += " ORDER BY imageType ASC index ASC ";
			ArrayList<ImageInfo> imageInfos = ImageInfoDBManager.getInstance().rawQuery(query);
			result.makeResponseTime();
			result.setErrorCode(Result.ERROR_CODE_OK);
			result.setResult(imageInfos);
			writeObject(result);
		}
	}
}
