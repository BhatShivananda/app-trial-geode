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
public class User implements PdxSerializable {
	
	private String id;
	private String name;
	private String accessToken;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void toData(PdxWriter writer) {
		writer.writeString("id", id)
		.markIdentityField("id")
		.writeString("name", name);
		
	}
	@Override
	public void fromData(PdxReader reader) {
		id = reader.readString("id");
		name = reader.readString("name");
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
