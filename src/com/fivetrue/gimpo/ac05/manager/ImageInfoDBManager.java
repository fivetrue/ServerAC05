package com.fivetrue.gimpo.ac05.manager;


import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.ImageInfo;

public class ImageInfoDBManager extends DatabaseManagerImpl<ImageInfo>{

	private static ImageInfoDBManager sInstance = null;
	
	protected ImageInfoDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
	}
	
	public static ImageInfoDBManager getInstance(){
		if(sInstance == null){
			sInstance = new ImageInfoDBManager();
		}
		return sInstance;
	}

	@Override
	protected Class<? extends ImageInfo> getDatabaseObjectClass() {
		// TODO Auto-generated method stub
		return ImageInfo.class;
	}

	@Override
	public ImageInfo getDefaultData() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
