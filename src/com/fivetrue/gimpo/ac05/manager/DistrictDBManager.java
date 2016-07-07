package com.fivetrue.gimpo.ac05.manager;


import com.fivetrue.db.DBMessage;
import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.District;

public class DistrictDBManager extends DatabaseManagerImpl<District>{

	private static DistrictDBManager sInstance = null;
	
	
	protected DistrictDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
	}
	
	public static DistrictDBManager getInstance(){
		if(sInstance == null){
			sInstance = new DistrictDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends District> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return District.class;
	}

	@Override
	public District getDefaultData() {
		// TODO Auto-generated method stub
		District district = new District();
		district.setDistrictNumber(501);
		district.setDistrictName("501동");
		district.setDistrictDesc("");
		district.setDistrictType("74A1");
		district.setCount(96);
		return district;
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
