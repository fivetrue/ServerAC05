package com.fivetrue.gimpo.ac05.manager;

import java.util.ArrayList;

import com.fivetrue.db.DBMessage;
import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.Admin;

public class AdminUserDBManager extends DatabaseManagerImpl<Admin>{

	private static AdminUserDBManager sInstance = null;
	
	
	protected AdminUserDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
		create();
	}
	
	public static AdminUserDBManager getInstance(){
		if(sInstance == null){
			sInstance = new AdminUserDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends Admin> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return Admin.class;
	}

	@Override
	public Admin getDefaultData() {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setAdminEmail("dudrpdjwls@naver.com");
		admin.setAdminId(15028068);;
		admin.setAdminType(3);
		return admin;
	}
	
	public Admin getAdmin(String email){
		Admin admin = null;
		ArrayList<Admin> admins = getSelectQueryData(null, "admin.adminEmail='" + email + "'");
		if(admins != null && admins.size() > 0){
			admin = admins.get(0);
		}
		return admin;
	}
	
	@Override
	public DBMessage create() {
		// TODO Auto-generated method stub
		DBMessage db = super.create();
		if(getCountData(null) <= 0){
			insertObject(getDefaultData());
		}
		return db;
	}

}
