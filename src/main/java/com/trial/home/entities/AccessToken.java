/**
 * 
 */
package com.trial.home.entities;

import com.gemstone.gemfire.pdx.PdxReader;
import com.gemstone.gemfire.pdx.PdxSerializable;
import com.gemstone.gemfire.pdx.PdxWriter;

/**
 * @author z078713
 *
 */
public class AccessToken implements PdxSerializable {

	private String userId;
	private String accessToken;
	private String logInType;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getLogInType() {
		return logInType;
	}
	public void setLogInType(String logInType) {
		this.logInType = logInType;
	}
	
	@Override
	public void toData(PdxWriter writer) {
		writer.writeString("userId", userId)
		.markIdentityField("userId")
		.writeString("accessToken", accessToken)
		.writeString("logInType", logInType);
	}
	
	@Override
	public void fromData(PdxReader reader) {
		userId = reader.readString(userId);
		accessToken = reader.readString(accessToken);
		logInType = reader.readString(logInType);
	}
}
