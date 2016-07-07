package com.fivetrue.gimpo.ac05.manager;

import java.util.ArrayList;

import com.fivetrue.db.DBMessage;
import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.UserInfo;

public class UserDBManager extends DatabaseManagerImpl<UserInfo>{

	private static UserDBManager sInstance = null;
	
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
		UserInfo user = new UserInfo();
		user.setEmail("dudrpdjwls@naver.com");
		user.setNickname("고구마감자");
		user.setEncId("6cea3f02bbbed6a2142142ca77fd3a457c66e0019007de3fbedb5e1fa1522e6d");
		user.setProfileImage("https://phinf.pstatic.net/contactthumb/20160701_103/14673565707785MLfq_JPEG/image.jpg?type=s80");
		user.setAge("30-39");
		user.setGender("M");
		user.setId("15028068");
		user.setName("권오진");
		user.setGcmId("APA91bHmu8p161n1MfxY9c0H8B0Iud4Y_IlGPkVBw4l2EZBaIhIEADnAYV4zPFOhTDsorMI7jPJttyMMOECjSdAPX_QvXuL1HP9kruE7r4Xvv9Ddd2gh7sr-WIBVzoFOOseXmcR-M385");
		user.setBirthday("11-01");
		user.setDevice("Custom Phone - 5.0.0 - API 21 - 768x1280");
		return user;
	}
	
	public UserInfo isExistUser(UserInfo user){
		UserInfo u = null;
		if(user != null && user.getEmail() != null){
			ArrayList<UserInfo> datas = getSelectQueryData(null, "email='" + user.getEmail() +"'");
			if(datas != null && datas.size() > 0){
				u = datas.get(0);
			}
		}
		return u;
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
