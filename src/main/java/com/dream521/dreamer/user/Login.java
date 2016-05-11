package com.dream521.dreamer.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dream521.dreamer.Models.User;

/**
 * 用户登录测试类
 * @author 周文中(love@dream521.com)
 *
 */
@Component
public class Login {
    
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
    public boolean login(String userName, String password){
    	User user = queryUser(userName, password);
    	if(null == user){
    		System.out.println("对不起，该用户不存在！");
    	}else{
    		System.out.println("登录成功！");
    	}
    	
    	return true;
    }
    
    /**
     * 连接数据库，返回用户
     * 查询单个用户使用getXxx，查询集合使用queryXxList
     */
    private User queryUser(String userName, String password){
    	try {
			//加载驱动
			Class.forName("org.mariadb.jdbc.Driver");
			//建立连接
			String url = "jdbc:mariadb://101.200.149.237:3306/test?useUnicode=true&characterEncoding=utf-8";
			Connection conn = DriverManager.getConnection(url, "root", "love@dream521.com");
			//创建SQL语句
			String sql = "SELECT * FROM t_user WHERE name=? ADN password=?";
			//执行SQL语句
			PreparedStatement preStat = conn.prepareStatement(sql);
			preStat.setString(1, userName);
			preStat.setString(2, password);
			ResultSet ret = preStat.executeQuery();
			//得到总的数据总数
			User user = new User();
			while(ret.next()){
				user.setUserName(ret.getString(2));
				user.setPassword(ret.getString(3));
				System.out.println("姓名 = "+ret.getString(2));
				System.err.println("密码 = "+ret.getString(3));
			}
			//关闭连接
			ret.close();
			preStat.close();
			conn.close();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
    	return null;
    }
}
