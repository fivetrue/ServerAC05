package com.fivetrue.gimpo.ac05.api;


import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fivetrue.api.Result;


public class ImageInfoApiHandler extends ProjectCheckApiHandler{


	private static final String TAG = "ImageInfoApiHandler";

	public ImageInfoApiHandler(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		super(context, request, response);
		// TODO Auto-generated constructor stub
	}
	
	
	public void getImageInfo(){
		if(checkRequestValidation()){
			
			
		}
	}
}
