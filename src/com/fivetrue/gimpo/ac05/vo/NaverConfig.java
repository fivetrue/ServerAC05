package com.fivetrue.gimpo.ac05.vo;

public class NaverConfig {
	
	private String clientId = null;
	private String clientSecret = null;
	private String termNconditionPage = null;
	private String signupCafeAPi = null;
	private String postActicleCafeApi = null;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getTermNconditionPage() {
		return termNconditionPage;
	}
	public void setTermNconditionPage(String termNconditionPage) {
		this.termNconditionPage = termNconditionPage;
	}
	public String getSignupCafeAPi() {
		return signupCafeAPi;
	}
	public void setSignupCafeAPi(String signupCafeAPi) {
		this.signupCafeAPi = signupCafeAPi;
	}
	public String getPostActicleCafeApi() {
		return postActicleCafeApi;
	}
	public void setPostActicleCafeApi(String postActicleCafeApi) {
		this.postActicleCafeApi = postActicleCafeApi;
	}
	@Override
	public String toString() {
		return "NaverConfig [clientId=" + clientId + ", clientSecret=" + clientSecret + ", termNconditionPage="
				+ termNconditionPage + ", signupCafeAPi=" + signupCafeAPi + ", postActicleCafeApi=" + postActicleCafeApi
				+ "]";
	}

}
