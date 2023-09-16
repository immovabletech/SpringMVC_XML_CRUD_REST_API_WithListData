package com.tech.immovable.bean;

import org.springframework.http.HttpStatus;

/**
 * --------------------------------------------------------------------------------------
 * --------------Copyright-(c)-Immovable-Technologies.-All-rights-reserved.--------------
 * ----------------------------User:immovabletech@gmail.com-----------------------------
 * --------------------------------------------------------------------------------------
 */

public class Response {
	private HttpStatus reqStatus;
	private String reqMsg;

	/**
	 * @return the reqStatus
	 */
	public HttpStatus getReqStatus() {
		return reqStatus;
	}

	/**
	 * @param reqStatus the reqStatus to set
	 */
	public void setReqStatus(HttpStatus reqStatus) {
		this.reqStatus = reqStatus;
	}

	/**
	 * @return the reqMsg
	 */
	public String getReqMsg() {
		return reqMsg;
	}

	/**
	 * @param reqMsg the reqMsg to set
	 */
	public void setReqMsg(String reqMsg) {
		this.reqMsg = reqMsg;
	}
}
