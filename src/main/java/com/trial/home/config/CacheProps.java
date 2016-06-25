package com.trial.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Shivananda Bhat
 *
 */
@Component
@PropertySource({"classpath:cache.properties"})
public class CacheProps {

	private final String host;
	private final Integer port;
	
	@Autowired
	public CacheProps(@Value("${cache.host}") String host,
			@Value("${cache.port}") Integer port) {
		this.host = host;
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public Integer getPort() {
		return port;
	}

}
