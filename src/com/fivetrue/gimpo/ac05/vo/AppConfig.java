package com.fivetrue.gimpo.ac05.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.AutoIncrement;
import com.fivetrue.db.annotation.PrimaryKey;

public class AppConfig extends DatabaseObject{
	@PrimaryKey
	@AutoIncrement
	public int configId = 0;
	
	public String appId;
	
	public int appVersionCode = 0;
	public String appSecretKey = null;
    public String appMarketUrl = null;
    public String senderId = null;

    /**
     * Naver Cafe Info
     */
    public String clubId = null;
    public String clubUrl = null;
    public String clubMyInfo = null;
    
    /**
     * Firebase Info
     */
    
    public String fDatabaseUrl;
    public String fStorageUrl;
    
    public int forceUpdate = 0;
    
    public String adminUrl = null;
    
}
