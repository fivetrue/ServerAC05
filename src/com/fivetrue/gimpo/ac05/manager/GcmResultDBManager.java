package com.fivetrue.gimpo.ac05.manager;


import com.fivetrue.db.DBMessage;
import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.GCMResult;
import com.google.gson.Gson;

public class GcmResultDBManager extends DatabaseManagerImpl<GCMResult>{

	private static GcmResultDBManager sInstance = null;
	
	
	protected GcmResultDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
	}
	
	public static GcmResultDBManager getInstance(){
		if(sInstance == null){
			sInstance = new GcmResultDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends GCMResult> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return GCMResult.class;
	}

	@Override
	public GCMResult getDefaultData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DBMessage insertObject(DatabaseObject data) {
		// TODO Auto-generated method stub
		GCMResult result = (GCMResult) data;
		result.setResult(new Gson().toJson(result.getResults()));
		return super.insertObject(data);
	}
	
}
