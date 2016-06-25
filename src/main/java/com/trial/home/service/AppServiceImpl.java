/**
 * 
 */
package com.trial.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.stereotype.Service;

import com.trial.home.entities.AccessToken;
import com.trial.home.entities.User;

/**
 * @author z078713
 *
 */
@Service
public class AppServiceImpl implements AppService {
	
	private final GemfireTemplate gemfireAccessTokenTemplate;
	private final GemfireTemplate gemfireUserTemplate;
	
	@Autowired
	public AppServiceImpl(GemfireTemplate gemfireAccessTokenTemplate, GemfireTemplate gemfireUserTemplate) {
		this.gemfireAccessTokenTemplate = gemfireAccessTokenTemplate;
		this.gemfireUserTemplate = gemfireUserTemplate;
	}

	@Override
	public void save(String key , String value) {
		User user = new User();
		user.setId(key);
		user.setName(value);
		gemfireUserTemplate.put(key, user);
		
		AccessToken accessToken = new AccessToken();
		accessToken.setUserId(key);
		accessToken.setAccessToken("edgvavvvvvwdgbfqfrqr");
		accessToken.setLogInType("TGT");
		gemfireAccessTokenTemplate.put(key, "edgvavvvvvwdgbfqfrqr");
	}

	@Override
	public User get(String key) {
		User user = gemfireUserTemplate.get(key);
		user.setAccessToken(gemfireAccessTokenTemplate.get(key));
		return user;
	}
	
}
