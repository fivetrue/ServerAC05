package com.fivetrue.gimpo.ac05.manager;

import java.util.ArrayList;

import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.PageData;

public class PageDataDBManager extends DatabaseManagerImpl<PageData>{

	private static PageDataDBManager sInstance = null;
	
	protected PageDataDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
	}
	
	public static PageDataDBManager getInstance(){
		if(sInstance == null){
			sInstance = new PageDataDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends PageData> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return PageData.class;
	}

	@Override
	public PageData getDefaultData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<PageData> getPageData(String type){
		String where = null;
		if(type != null){
			where = "pagedata.type='" + type +"'";
		}
		return getSelectQueryData(null , where);
		
	}
	
	public ArrayList<PageData> getPageDataWithWhere(String where){
		return getSelectQueryData(null , where);
		
	}
	

}
