package com.fivetrue.gimpo.ac05;

public class NaverConstants {

	public static final String HEADER_KEY_X_NAVER_CLIENT_ID = "X-Naver-Client-Id";
	public static final String HEADER_KEY_X_NAVER_CLIENT_SECRET = "X-Naver-Client-Secret";
	public static final String HEADER_KEY_AUTHORIZATION = "Authorization";
	
	public static final String CLIENT_ID = "9T3rCkMdIwOEB9RXFEJN";
	public static final String CLIENT_SECRET = "uCng89rNWO";
	
	public static final class Login{
		public static final String LOGIN_AUTH_API = "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=" + CLIENT_ID + "&redirect_uri=%s&state=%s";
//		https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=jyvqXeaVOVmV&redirect_uri=http%3A%2F%2Fservice.redirect.url%2Fredirect&state=hLiDdL2uhPtsftcU
		public static final String REDIRECT_CALLBACK_URL = "";
		
	}
	
	
	public static final class Cafe{
		
//		config.clubId = "27521358"; // 병점 카페.
//		config.clubId = "28622122"; // 테스트 카페.
		public static final String CAFE_ID = "27521358";
		public static final String CAFE_URL = "http://cafe.naver.com/gimpoac05";
		public static final String TERM_AND_CONDITION_URL = "http://cafe.naver.com/common/cafein_service.htm";
		
		public static final String SIGNUP_CAFE_API = "https://openapi.naver.com/cafe/cafeApply.json";
		public static final String POST_ACTICLE_CAFE_API = "https://openapi.naver.com/cafe/articlePost.json";
	}
}
