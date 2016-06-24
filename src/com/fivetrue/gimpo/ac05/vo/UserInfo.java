package com.fivetrue.gimpo.ac05.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class UserInfo extends DatabaseObject {
	
		@PrimaryKey
		@StringLength(128)
	    private String email = null;
		
		@StringLength(64)
		private String nickname = null;
		@StringLength(128)
	    private String encId = null;
		@StringLength(128)
	    private String profileImage = null;
		@StringLength(32)
	    private String age = null;
		@StringLength(4)
	    private String gender = null;
		@StringLength(24)
	    private String id = null;
		@StringLength(64)
	    private String name = null;
		@StringLength(16)
	    private String birthday = null;

	    private String gcmId = null;
	    @StringLength(32)
	    private String device = null;
	    
	    private String apartDong = null;
	    
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getNickname() {
	        return nickname;
	    }

	    public void setNickname(String nickname) {
	        this.nickname = nickname;
	    }

	    public String getEncId() {
	        return encId;
	    }

	    public void setEncId(String encId) {
	        this.encId = encId;
	    }

	    public String getProfileImage() {
	        return profileImage;
	    }

	    public void setProfileImage(String profileImage) {
	        this.profileImage = profileImage;
	    }

	    public String getAge() {
	        return age;
	    }

	    public void setAge(String age) {
	        this.age = age;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getBirthday() {
	        return birthday;
	    }

	    public void setBirthday(String birthday) {
	        this.birthday = birthday;
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
	    
	    public String getApartDong() {
			return apartDong;
		}

		public void setApartDong(String apartDong) {
			this.apartDong = apartDong;
		}

		@Override
		public String toString() {
			return "UserInfo [email=" + email + ", nickname=" + nickname + ", encId=" + encId + ", profileImage="
					+ profileImage + ", age=" + age + ", gender=" + gender + ", id=" + id + ", name=" + name
					+ ", birthday=" + birthday + ", gcmId=" + gcmId + ", device=" + device + ", apartDong=" + apartDong + "]";
		}

}
