package com.bright.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bright.bean.User;

public final class App {
	private static App instance;
	private ApplicationContext ctx;//程序上下文
	private User user;// 当前用户

	public ApplicationContext getApplicationContext() {
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return ctx;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static App getInstance() {
		if (instance == null) {
			instance = new App();
		}
		return instance;
	}

}
