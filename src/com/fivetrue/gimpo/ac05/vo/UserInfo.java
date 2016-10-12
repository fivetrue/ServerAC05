package com.fivetrue.gimpo.ac05.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.DisplayName;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class UserInfo extends DatabaseObject {
	
		@PrimaryKey
		@StringLength(128)
	    private String uid = null;
		
		@StringLength(128)
		@DisplayName("이메일")
	    private String email = null;
		
		@StringLength(64)
	    private String displayName = null;
		
		@StringLength(128)
		@DisplayName("프로필 이미지")
	    private String photoUrl = null;
		
		@StringLength(64)
		@DisplayName("프로바이더")
		private String providerId = null;
	
	    private String gcmId = null;
	    
	    @DisplayName("디바이스")
	    private String device = null;
	    
	    @DisplayName("구역")
	    private int district = 0;
	    
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		public String getDisplayName() {
			return displayName;
		}

		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}

		public String getPhotoUrl() {
			return photoUrl;
		}

		public void setPhotoUrl(String photoUrl) {
			this.photoUrl = photoUrl;
		}

		public String getProviderId() {
			return providerId;
		}

		public void setProviderId(String providerId) {
			this.providerId = providerId;
		}

		public String getGcmId() {
			return gcmId;
		}

		public void setGcmId(String gcmId) {
			this.gcmId = gcmId;
		}

		public String getDevice() {
			return device;
		}

		public void setDevice(String device) {
			this.device = device;
		}

		public int getDistrict() {
			return district;
		}

		public void setDistrict(int district) {
			this.district = district;
		}
		
		public void updateUser(UserInfo info){
			this.device  = info.device;
			this.displayName = info.displayName;
			this.district = info.district;
			this.email = info.email;
			this.gcmId = info.gcmId;
			this.photoUrl = info.photoUrl;
			this.providerId = info.providerId;
			this.uid = info.uid;
		}
	    
	    

}
