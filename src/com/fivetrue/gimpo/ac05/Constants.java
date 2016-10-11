package com.fivetrue.gimpo.ac05;

public class Constants {
	
	public static final String DB_SERVER = "localhost";
	public static final String DB_NAME = "gimpoac05";
	public static final String DB_ID = "root";
	public static final String DB_PASS = "maru0411";

	public static final String KEY_APP_ID = "Application-ID";
	public static final String KEY_APP_KEY = "Application-Key";
	
	public static final String APP_ID = "com.fivetrue.gimpo.ac05";
	public static final String APP_KEY = "com.fivetrue";
	
	public static final int APP_LATEST_VERSION = 123;
	public static final String APP_MARKET_URL = "http://play.google.com/";
	
	public static class GCM{
		public static String GCM_SEND_SERVER_URL = "https://gcm-http.googleapis.com/gcm/send";
		public static String GCM_KEY = "AIzaSyAWEH17enSgJXZzLztFi2eCIJoF5X8KtPM";
		public static String GCM_SENDER_ID = "78268034449";
	}
	
	public static class FIREBASE{
		public static String FIREBASE_DB_URI = "https://gimpo-1334.firebaseio.com/";
		public static String FIREBASE_STORAGE_URI = "gs://gimpo-1334.appspot.com";
	}
}
