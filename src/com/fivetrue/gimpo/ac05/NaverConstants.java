package com.fivetrue.gimpo.ac05;

public class NaverConstants {

	public static final String HEADER_KEY_X_NAVER_CLIENT_ID = "X-Naver-Client-Id";
	public static final String HEADER_KEY_X_NAVER_CLIENT_SECRET = "X-Naver-Client-Secret";
	
	public static final String CLIENT_ID = "MGbWmO0Ao2NByX4wkHFu";
	public static final String CLIENT_SECRET = "oZ7749b7xJ";
	
	public static final class Login{
		public static final String LOGIN_AUTH_API = "https://nid.naver.com/oauth2.0/authorize";
		
		public static final String REDIRECT_CALLBACK_URL = "";
		
	}
	
	
	public static final class Cafe{
		public static final String TERM_AND_CONDITION_URL = "http://cafe.naver.com/common/cafein_service.htm";
		
		public static final String SIGNUP_CAFE_API = "https://openapi.naver.com/cafe/cafeApply.json";
		public static final String POST_ACTICLE_CAFE_API = "https://openapi.naver.com/cafe/articlePost.json";
	}
}
