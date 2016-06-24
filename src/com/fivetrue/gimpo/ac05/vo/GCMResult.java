package com.fivetrue.gimpo.ac05.vo;

import java.util.ArrayList;

import com.fivetrue.db.DatabaseObject;
import com.fivetrue.db.annotation.MemberVariable;
import com.fivetrue.db.annotation.PrimaryKey;
import com.fivetrue.db.annotation.StringLength;

public class GCMResult extends DatabaseObject{

	@PrimaryKey
	private String multicast_id = null;
	private int success = 0;
	private int failure = 0;
	private String canonical_ids = null;
	
	@StringLength(512 * 2)
	private String result = null;
	
	@MemberVariable
	private ArrayList<Result> results = null;
	
	public String getMulticast_id() {
		return multicast_id;
	}
	public void setMulticast_id(String multicast_id) {
		this.multicast_id = multicast_id;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public int getFailure() {
		return failure;
	}
	public void setFailure(int failure) {
		this.failure = failure;
	}
	public String getCanonical_ids() {
		return canonical_ids;
	}
	public void setCanonical_ids(String canonical_ids) {
		this.canonical_ids = canonical_ids;
	}
	public ArrayList<Result> getResults() {
		return results;
	}
	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}



	public static final class Result{
		private String message_id = null;

		public String getMessage_id() {
			return message_id;
		}

		public void setMessage_id(String message_id) {
			this.message_id = message_id;
		}

		@Override
		public String toString() {
			return "Result [message_id=" + message_id + "]";
		}
	}
	
	@Override
	public String toString() {
		return "GCMResult [multicast_id=" + multicast_id + ", success=" + success + ", failure=" + failure
				+ ", canonical_ids=" + canonical_ids + ", result=" + result + ", results=" + results + "]";
	}
}
