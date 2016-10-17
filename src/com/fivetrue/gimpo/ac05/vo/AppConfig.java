package com.fivetrue.gimpo.ac05.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.AutoIncrement;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class AppConfig extends DatabaseObject{
	@PrimaryKey
	@AutoIncrement
	public int configId = 0;
	
	@StringLength(68)
	public String appId;
	
	public int appVersionCode = 0;
	@StringLength(68)
	public String appSecretKey = null;
	@StringLength(128)
    public String appMarketUrl = null;
	@StringLength(68)
    public String senderId = null;

    /**
     * Naver Cafe Info
     */
	@StringLength(32)
    public String clubId = null;
	@StringLength(128)
    public String clubUrl = null;
	@StringLength(128)
    public String clubMyInfo = null;
    
    /**
     * Firebase Info
     */
    
    public String fDatabaseUrl;
    public String fStorageUrl;
    
    public int forceUpdate = 0;
    
    public String adminUrl = null;
    
    public String defaultImageUrl;
    
}
