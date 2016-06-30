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
		public static final String AUTH_TOKEN_API = "https://nid.naver.com/oauth2.0/token";
		public static final String REDIRECT_CALLBACK_URL = "http://52.76.24.8:8080/gimpoac05/naver/callback";
		
	}
	
	
	public static final class User{
		public static final String INFO_API = "https://openapi.naver.com/v1/nid/me";
		public static final String MY_INFO_URL = "https://nid.naver.com/user2/help/myInfo.nhn?menu=home";
	}
	
	
	public static final class Cafe{
		
//		config.clubId = "27521358"; // 병점 카페.
//		config.clubId = "28622122"; // 테스트 카페.
		public static final String CAFE_ID = "28051000";
		public static final String CAFE_URL = "http://cafe.naver.com/gimpoac05";
		public static final String CAFE_USER_INFO_URL = "http://cafe.naver.com/CafeMemberInfo.nhn?clubid=" + CAFE_ID + "&memberid=";
		public static final String TERM_AND_CONDITION_URL = "http://cafe.naver.com/common/cafein_service.htm";
		
//		public static final String SIGNUP_CAFE_API = "https://openapi.naver.com/cafe/cafeApply.json";
		public static final String SIGNUP_CAFE_API = "https://openapi.naver.com/v1/cafe/%s/members";
		public static final String POST_ACTICLE_CAFE_API = "https://openapi.naver.com/cafe/articlePost.json";
	}
}
