/**
 * 
 */
package com.trial.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trial.home.entities.User;
import com.trial.home.service.AppService;

/**
 * @author Shivananda Bhat
 *
 */
@RestController
public class HelloController {
	
	private final AppService appService;
	
	@Autowired
	public HelloController(AppService appService) {
		this.appService = appService;
	}
	
	@RequestMapping("/testPut")
	public String testPut(@RequestParam(value = "value", required = true) final String value) {
		appService.save(value, value);
		return "Key and Value saved in Geode!";
	}
	
	@RequestMapping("/testGet")
	public User testGet(@RequestParam(value = "key", required = true) final String key) {
		return appService.get(key);
	}
}
