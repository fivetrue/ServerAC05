package com.fivetrue.gimpo.ac05.manager;


import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.NotificationDataCheckUser;

public class NotificationDataCheckUserDBManager extends DatabaseManagerImpl<NotificationDataCheckUser>{

	private static NotificationDataCheckUserDBManager sInstance = null;
	
	
	protected NotificationDataCheckUserDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
		create();
	}
	
	public static NotificationDataCheckUserDBManager getInstance(){
		if(sInstance == null){
			sInstance = new NotificationDataCheckUserDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends NotificationDataCheckUser> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return NotificationDataCheckUser.class;
	}

	@Override
	public NotificationDataCheckUser getDefaultData() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
