package com.fivetrue.gimpo.ac05.manager;

import java.util.ArrayList;

import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.UserInfo;
import com.fivetrue.utils.TextUtils;

public class UserDBManager extends DatabaseManagerImpl<UserInfo>{

	private static UserDBManager sInstance = null;
	
	protected UserDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
		create();
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
		return null;
	}
	
	public UserInfo isExistUser(UserInfo user){
		return isExistUser(user.getUid());
	}
	
	public UserInfo isExistUser(String uid){
		UserInfo u = null;
		if(!TextUtils.isEmpty(uid)){
			ArrayList<UserInfo> datas = getSelectQueryData(null, "uid='" + uid +"'");
			if(datas != null && datas.size() > 0){
				u = datas.get(0);
			}
		}
		return u;
	}
	

}
