package com.fivetrue.gimpo.ac05.manager;

import java.util.ArrayList;
import java.util.Base64;

import com.fivetrue.db.DBMessage;
import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.TownData;

public class TownDataDBManager extends DatabaseManagerImpl<TownData>{

	private static TownDataDBManager sInstance = null;
	
	protected TownDataDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
		create();
	}
	
	public static TownDataDBManager getInstance(){
		if(sInstance == null){
			sInstance = new TownDataDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends TownData> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return TownData.class;
	}

	@Override
	public TownData getDefaultData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DBMessage insertObject(DatabaseObject data) {
		// TODO Auto-generated method stub
		TownData town = (TownData) data;
		town.setContent(Base64.getEncoder().encodeToString(town.getContent().getBytes()));
		town.setTitle(Base64.getEncoder().encodeToString(town.getTitle().getBytes()));
		return super.insertObject(data);
	}
	
	@Override
	public ArrayList<TownData> getSelectQueryData(String[] selection, String where) {
		// TODO Auto-generated method stub
		ArrayList<TownData> data = super.getSelectQueryData(selection, where);
		for(TownData t : data){
			t.setContent(new String(Base64.getDecoder().decode(t.getContent())));
			t.setTitle(new String(Base64.getDecoder().decode(t.getTitle())));
		}
		return data;
	}
	
	
	@Override
	public ArrayList<TownData> rawQuery(String query) {
		// TODO Auto-generated method stub
		ArrayList<TownData> data = super.rawQuery(query);
		for(TownData t : data){
			t.setContent(new String(Base64.getDecoder().decode(t.getContent())));
			t.setTitle(new String(Base64.getDecoder().decode(t.getTitle())));
		}
		return data;
	}

}
