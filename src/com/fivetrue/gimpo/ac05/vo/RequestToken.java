package com.fivetrue.gimpo.ac05.vo;

import com.fivetrue.gimpo.ac05.NaverConstants;

/*
 * 3.2. 접근토큰 발급/갱신/삭제 요청
접근토큰 발급/갱신/삭제 요청 요청 변수 설명 표
요청 변수명	타입	필수여부	기본값	설명
grant_type	string	Y	-	인증 과정에 대한 구분값 
1) 발급:'authorization_code' 
2) 갱신:'refresh_token' 
3) 삭제: 'delete'
client_id	string	Y	-	애플리케이션 등록시 발급받은 Client ID 값
client_secret	string	Y	-	애플리케이션 등록시 발급받은 Client secret 값
code	string	발급 때 필수	-	로그인 인증 요청 API 호출에 성공하고 리턴받은 인증코드값 (authorization code)
state	string	발급 때 필수	-	사이트 간 요청 위조(cross-site request forgery) 공격을 방지하기 위해 애플리케이션에서 생성한 상태 토큰값으로 URL 인코딩을 적용한 값을 사용
refresh_token	string	갱신 때 필수	-	네이버 사용자 인증에 성공하고 발급받은 갱신 토큰(refresh token)
access_token	string	삭제 때 필수	-	기 발급 받은 접근 토큰으로 URL 인코딩을 적용한 값을 사용
sercive_provider	string	삭제 때 필수	'NAVER'	인증 제공자 이름으로 'NAVER'로 세팅해 전송
*/
public class RequestToken {
	
	private String grant_type = null;
	private String client_id = NaverConstants.CLIENT_ID;
	private String client_secret = NaverConstants.CLIENT_SECRET;
	private String code = null;
	private String state = null;
	private String refresh_token = null;
	private String access_token = null;
	private String sercive_provider = "NAVER";
	
	public static RequestToken makeAccessTokenParameter(String code, String state){
		RequestToken request = new RequestToken();
		request.grant_type = "authorization_code";
		request.code = code;
		request.state = state;
		return request;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_secret() {
		return client_secret;
	}

	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getSercive_provider() {
		return sercive_provider;
	}

	public void setSercive_provider(String sercive_provider) {
		this.sercive_provider = sercive_provider;
	}

	@Override
	public String toString() {
		return "RequestToken [grant_type=" + grant_type + ", client_id=" + client_id + ", client_secret="
				+ client_secret + ", code=" + code + ", state=" + state + ", refresh_token=" + refresh_token
				+ ", access_token=" + access_token + ", sercive_provider=" + sercive_provider + "]";
	}
	
}
