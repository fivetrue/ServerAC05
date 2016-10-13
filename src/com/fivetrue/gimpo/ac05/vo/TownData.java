package com.fivetrue.gimpo.ac05.vo;


import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.AutoIncrement;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class TownData extends DatabaseObject{
	
	@AutoIncrement
	@PrimaryKey
	public int postId = 0;
	
	public String title = null;
	
	@StringLength(256)
	public String url = null;
	
	public String author = null;
	public String date = null;
	
	@StringLength(2048*8)
	public String content = null;

	
}
