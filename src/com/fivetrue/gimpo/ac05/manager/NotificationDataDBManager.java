package com.fivetrue.gimpo.ac05.manager;

import java.util.ArrayList;

import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.Admin;
import com.fivetrue.gimpo.ac05.vo.NotificationData;

public class NotificationDataDBManager extends DatabaseManagerImpl<NotificationData>{

	private static NotificationDataDBManager sInstance = null;
	
	
	protected NotificationDataDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
	}
	
	public static NotificationDataDBManager getInstance(){
		if(sInstance == null){
			sInstance = new NotificationDataDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends NotificationData> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return NotificationData.class;
	}

	@Override
	public NotificationData getDefaultData() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
