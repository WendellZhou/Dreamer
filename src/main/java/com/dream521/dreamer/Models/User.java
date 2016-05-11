package com.dream521.dreamer.Models;

import org.springframework.stereotype.Component;

/**
 * 用户实体类
 * @author 周文中(love@dream521.com)
 *
 */
@Component
public class User {
    /**用户名*/
    private String userName;
    /**密码*/
    private String password;
    
    //基本set和 get方法
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
