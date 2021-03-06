package com.fivetrue.gimpo.ac05.manager;


import java.util.ArrayList;

import com.fivetrue.db.PageData;
import com.fivetrue.db.manager.DatabaseManagerImpl;
import com.fivetrue.gimpo.ac05.Constants;
import com.fivetrue.gimpo.ac05.vo.ImageInfo;
import com.fivetrue.gimpo.ac05.vo.ImageInfoEntry;

public class ImageInfoDBManager extends DatabaseManagerImpl<ImageInfo>{

	private static ImageInfoDBManager sInstance = null;
	
	protected ImageInfoDBManager() {
		super(Constants.DB_SERVER, Constants.DB_NAME, Constants.DB_ID, Constants.DB_PASS);
		// TODO Auto-generated constructor stub
		create();
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
	
	public ArrayList<ImageInfoEntry> getImageInfoEntry(String limit){
		ArrayList<ImageInfo> imageGroup = getSelectQueryData(null, null, "GROUP BY imageType ORDER BY createTime DESC");
		ArrayList<ImageInfoEntry> imageInfoEntry = new ArrayList<>();
		for(ImageInfo g : imageGroup){
			ImageInfoEntry entry = new ImageInfoEntry();
			ArrayList<ImageInfo> imageInfos = getSelectQueryData(null, "imageType='"+ g.getImageType()  + "'", "ORDER BY createTime DESC " + (limit != null ? limit : "") );
			entry.setTitle(g.getImageName());
			entry.setContent(g.getDescription());
			entry.setImageInfos(imageInfos);
			entry.setUpdateDate(g.getCreateTime());
			entry.setTotalCount(getCountData("imageType='"+ g.getImageType()  + "'"));
			imageInfoEntry.add(entry);
		}
		return imageInfoEntry;
	}
	
}
