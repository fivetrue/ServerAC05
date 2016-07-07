package com.fivetrue.gimpo.ac05.vo;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.DisplayName;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class UserInfo extends DatabaseObject {
	
		@PrimaryKey
		@StringLength(128)
		@DisplayName("이메일")
	    private String email = null;
		
		@StringLength(64)
		@DisplayName("넥네임")
		private String nickname = null;
		@StringLength(128)
	    private String encId = null;
		@StringLength(128)
		@DisplayName("프로필 이미지")
	    private String profileImage = null;
		@StringLength(32)
		@DisplayName("나이")
	    private String age = null;
		@StringLength(4)
		@DisplayName("성별")
	    private String gender = null;
		@StringLength(24)
	    private String id = null;
		@StringLength(64)
	    private String name = null;
		@StringLength(16)
	    private String birthday = null;

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

		public int getDistrict() {
			return district;
		}

		public void setDistrict(int district) {
			this.district = district;
		}

		@Override
		public String toString() {
			return "UserInfo [email=" + email + ", nickname=" + nickname + ", encId=" + encId + ", profileImage="
					+ profileImage + ", age=" + age + ", gender=" + gender + ", id=" + id + ", name=" + name
					+ ", birthday=" + birthday + ", gcmId=" + gcmId + ", device=" + device + ", district=" + district + "]";
		}
}
