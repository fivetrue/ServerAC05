package com.fivetrue.gimpo.ac05.manager;

import java.util.ArrayList;

import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.UserInfo;

public class UserDBManager extends DatabaseManagerImpl<UserInfo>{

	private static UserDBManager sInstance = null;
	
	private UserInfo mTempUserInfo = null;
	
	protected UserDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
	}
	
	public static UserDBManager getInstance(){
		if(sInstance == null){
			sInstance = new UserDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends UserInfo> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return UserInfo.class;
	}

	@Override
	public UserInfo getDefaultData() {
		// TODO Auto-generated method stub
		return mTempUserInfo;
	}
	
	public boolean isExistUser(UserInfo user){
		boolean b = false;
		if(user != null && user.getEmail() != null){
			mTempUserInfo = user;
			ArrayList<UserInfo> datas = getSelectQueryData(null, "email='" + user.getEmail() +"'");
			b = datas != null && datas.size() > 0;
		}
		return b;
	}
	

}
