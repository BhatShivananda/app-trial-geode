/**
 * 
 */
package com.trial.home.service;

import com.trial.home.entities.User;

/**
 * @author z078713
 *
 */
public interface AppService {

	void save(String key , String value);
	User get(String key);
}
