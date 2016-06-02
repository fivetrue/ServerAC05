package com.fivetrue.gimpo.ac05.error;

public enum NaverErrorCode implements Runnable {
	
	/**
	 * Login Error code
	 */
//	
//	에러 코드 설명 표
//	HTTP코드	에러코드	에러 메시지	조치방안
//	500	500	
//	-	invalid_request	파라미터가 잘못되었거나 요청문이 잘못되었습니다.	-
//	-	unauthorized_client	인증받지 않은 인증 코드(authorization code)로 요청했습니다.	-
//	-	unsupported_response_type	정의되지 않은 반환 형식으로 요청했습니다.	-
//	-	server_error	네이버 인증 서버의 오류로 요청을 처리하지 못했습니다.	-
	LOGIN_AUTH_FAIL_ERROR("024", "Authentication failed / 인증에 실패했습니다."),
	NOT_EXISTS_AUTH_HEADER_ERROR("028", "Authentication header not exists / OAuth 인증 헤더(authorization header)가 없습니다."),
	PERMISSION_DENIED_ERROR("403", "Forbidden / 호출 권한이 없습니다.	API 요청 헤더에 클라이언트 ID와 Secret 값을 정확히 전송했는지 확인해보시길 바랍니다."),
	NOT_FOUND_ERROR("404", "검색 결과가 없습니다.	"),
	INTERNAL_SERVER_ERROR("500", "Internal Server Error / 데이터베이스 오류입니다.	서버 내부 에러가 발생하였습니다. 포럼에 올려주시면 신속히 조치하겠습니다."),
	
	
	/**
	 * Signup Error code
	 */
	UNKNOWN_ERROR("999", "알 수 없는 에러가 발생하였습니다."),
	CAFE_ACCESS_DENIED_ERROR("0005", "접속하신 카페는 카페 멤버만 들어가실 수 있습니다. (비공개 카페 접근 시)"),
	ALREADY_SIGNUP_ERROR("CA001","이미 가입을 신청했으며, 현재 가입 승인 절차가 진행 중입니다."),
	CAFE_BLOCK_USER_ERROR("CA002","아이디가 이용 정지 상태입니다."),
	PRIVATE_CAFE_ERROR("CA003","공개 및 바로 가입 가능한 카페만, 가입이 가능합니다."),
	BLANK_NICKNAME_ERROR("NN001","빈칸으로만 이루어진 별명은 사용할 수 없습니다."),
	SHORT_NICKNAME_ERROR("NN002", "별명은 2바이트 이상 입력해야 합니다."),
	LONG_NICKNAME_ERROR("NN003","별명은 20바이트까지 입력할 수 있습니다."),
	WRONG_NICKNAME_ERROR("NN004","별명은 한글, 영문, 숫자만 사용할 수 있습니다."),
	WRONG_WORD_IN_NICKNAME_ERROR("NN005", "별명에 금칙어를 포함할 수 없습니다."),
	DUPLICATE_NICKNAME_ERROR("NN006", "카페에 동일한 별명이 있습니다."),
	
	/**
	 * Post Error code
	 */
	PARAMETER_ERROR("AP001", "요청한 파라미터가 유효하지 않습니다."),
	BOARD_ACCESS_DENIED_ERROR("AP002", "접근 제한 중인 게시판입니다."),
	USER_LEVEL_ERROR("AP003", "카페에서 특정한 등급의 멤버만 쓸 수 있는 게시판입니다."),
	INVALID_ACCESS_ERROR("AP004", "비정상적인 접근입니다(끌쓰기 허용 불가 메뉴)."),
	WRONG_WORD_IN_POST_ERROR("AP005", "카페 운영진이 설정한 금칙어 및 스팸글 자동차단 기능에 의해 해당 게시글은 스팸 보관함으로 이동했습니다."),
	NOT_EXIST_CAFE_ERROR("AP006", "카페가 존재하지 않습니다."),
	INACTIVE_USER_ERROR("AP007", "현재 활동 정지 상태입니다. 활동 정지가 해제되기 전까지 해당 카페에 게시글을 쓸 수 없습니다."),
	BLOCK_USER_ERROR("AP008", "아이디가 이용 정지 상태입니다."),
	
	/**
	 * Cafe Common Error code
	 */
	MAINTERANCE_SERVICE_ERROR("006", "서비스 점검 중입니다."),
	ILLEGAL_CAFE_ERROR("007", "이 카페에는 접근할 수 없습니다. 이 카페는 네이버 이용약관 및 운영원칙에서 제한하고 있는 목적으로 개설되었거나 제한 대상 게시물을 다수 포함하고 있어 접근이 제한되었습니다."),
	INVALID_REQUEST_ERROR("9999", "잘못된 접근입니다(잘못된 카페 정보 요청 시 등)."),
	
	/**
	 * Common Error code
	 */
	SYSTEM_ERROR("000", "시스템 에러."),
	QUERY_LIMIT_ERROR("010", "쿼리 한도가 초과되었습니다."),
	UNREGISTER_KEY_ERROR("020", "등록되지 않은 키입니다."),
	USELESS_KEY_ERROR("021", "사용할 수 없는 키입니다."),
	AUTH_FAIL_ERROR("024", "인증 실패하였습니다."),
	INVALID_OAUTH_HEADER_ERROR("028", "OAuth Header가 없습니다."),
	AUTH_REQUEST_ERROR("029", "요청한 Authorization 값을 확인할 수 없습니다."),
	HTTPS_ERROR("030", "HTTPS로 호출해야 합니다."),
	SERVICE_ACCESS_DENIED_ERROR("031", "서비스에 대한 호출 권한이 없습니다."),
	NOT_EXIST_API_ERROR("051", "존재하지 않는 API입니다."),
	INVALID_URL_REQUEST_ERROR("061", "잘못된 형식의 호출 URL입니다."),
	INVALID_PARAMETER_REQUEST_ERROR("062", "잘못된 형식의 호출 파라미터입니다."),
	INVALID_INCODING_ERROR("063", "잘못된 형식의 인코딩 문자입니다."),
	NOT_SUPPORT_TYPE_ERROR("071", "지원하지 않는 반환 형식입니다."),
	UNDEFINED_ERROR("900", "정의되지 않은 오류가 발생하였습니다.");
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("errorCode = " + errorCode + " / Message = " + getErrorMessage());
	}
	
	private String errorCode = null;
	private String errorMessage = null;
	
	private NaverErrorCode(String code, String message){
		this.errorCode = code;
		this.errorMessage = message;
	}

	public String getErrorCode() {
		// TODO Auto-generated method stub
		return errorCode;
	}
	
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return errorMessage;
	}

	public boolean compare(NaverErrorCode code) {
		// TODO Auto-generated method stub
		if(code != null){
			return code.getErrorCode().equals(errorCode);
		}
		return false;
	}
}
