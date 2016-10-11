package com.fivetrue.gimpo.ac05.manager;


import com.fivetrue.db.DBMessage;
import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.NaverConstants;
import com.fivetrue.gimpo.ac05.vo.AppConfig;

public class AppConfigDBManager extends DatabaseManagerImpl<AppConfig>{

	private static AppConfigDBManager sInstance = null;
	
	
	protected AppConfigDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
	}
	
	public static AppConfigDBManager getInstance(){
		if(sInstance == null){
			sInstance = new AppConfigDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends AppConfig> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return AppConfig.class;
	}

	@Override
	public AppConfig getDefaultData() {
		// TODO Auto-generated method stub
		AppConfig config = new AppConfig();
		config.appId = Constants.APP_ID;
		config.appMarketUrl = Constants.APP_MARKET_URL;
		config.appSecretKey = Constants.APP_KEY;
		config.appVersionCode = Constants.APP_LATEST_VERSION;
		config.clubId = NaverConstants.Cafe.CAFE_ID;
		config.clubMyInfo = NaverConstants.Cafe.CAFE_USER_INFO_URL;
		config.clubUrl = NaverConstants.Cafe.CAFE_URL;
		config.senderId = Constants.GCM.GCM_SENDER_ID;
		config.fDatabaseUrl = Constants.FIREBASE.FIREBASE_DB_URI;
		config.fStorageUrl = Constants.FIREBASE.FIREBASE_STORAGE_URI;
		return config;
	}
	
	@Override
	public DBMessage create() {
		// TODO Auto-generated method stub
		DBMessage msg = super.create();
		if(getCountData(null) <= 0){
			insertObject(getDefaultData());
		}
		return msg;
	}
	
}
