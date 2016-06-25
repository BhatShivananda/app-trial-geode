package com.trial.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.GemfireTemplate;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.trial.home.entities.AccessToken;
import com.trial.home.entities.User;

/**
 * @author z078713
 *
 */
@Configuration
public class CacheConfiguration {

	@Autowired
	private CacheProps cacheProps;
	
	@Bean
	public ClientCache cacheTemplate() {
		ClientCache cache = new ClientCacheFactory().addPoolLocator(
				cacheProps.getHost(), cacheProps.getPort()).create();
		return cache;
	}

	@Bean
	public Region<String, User> getUserRegion() {
		return cacheTemplate().<String, User> createClientRegionFactory(
				ClientRegionShortcut.CACHING_PROXY).create("user");
	}


	@Bean
	public Region<String, AccessToken> getAccessTokenRegion() {
		return cacheTemplate().<String, AccessToken> createClientRegionFactory(
				ClientRegionShortcut.CACHING_PROXY).create("accesstoken");
	}

	@Bean
	public GemfireTemplate gemfireUserTemplate() {
		GemfireTemplate gemfireTemplate = new GemfireTemplate(getUserRegion());
		return gemfireTemplate;
	}

	@Bean
	public GemfireTemplate gemfireAccessTokenTemplate() {
		GemfireTemplate gemfireTemplate = new GemfireTemplate(
				getAccessTokenRegion());
		return gemfireTemplate; 
	}
	
}
