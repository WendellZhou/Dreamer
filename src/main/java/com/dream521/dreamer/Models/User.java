package com.dream521.dreamer.Models;

import org.springframework.stereotype.Component;

/**
 * �û�ʵ����
 * @author ������(love@dream521.com)
 *
 */
@Component
public class User {
    /**�û���*/
    private String userName;
    /**����*/
    private String password;
    
    //����set�� get����
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
