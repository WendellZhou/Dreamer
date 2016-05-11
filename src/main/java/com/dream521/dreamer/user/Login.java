package com.dream521.dreamer.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dream521.dreamer.Models.User;

/**
 * �û���¼������
 * @author ������(love@dream521.com)
 *
 */
@Component
public class Login {
    
	/**
	 * �û���¼
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
    public boolean login(String userName, String password){
    	User user = queryUser(userName, password);
    	if(null == user){
    		System.out.println("�Բ��𣬸��û������ڣ�");
    	}else{
    		System.out.println("��¼�ɹ���");
    	}
    	
    	return true;
    }
    
    /**
     * �������ݿ⣬�����û�
     * ��ѯ�����û�ʹ��getXxx����ѯ����ʹ��queryXxList
     */
    private User queryUser(String userName, String password){
    	try {
			//��������
			Class.forName("org.mariadb.jdbc.Driver");
			//��������
			String url = "jdbc:mariadb://101.200.149.237:3306/test?useUnicode=true&characterEncoding=utf-8";
			Connection conn = DriverManager.getConnection(url, "root", "love@dream521.com");
			//����SQL���
			String sql = "SELECT * FROM t_user WHERE name=? ADN password=?";
			//ִ��SQL���
			PreparedStatement preStat = conn.prepareStatement(sql);
			preStat.setString(1, userName);
			preStat.setString(2, password);
			ResultSet ret = preStat.executeQuery();
			//�õ��ܵ���������
			User user = new User();
			while(ret.next()){
				user.setUserName(ret.getString(2));
				user.setPassword(ret.getString(3));
				System.out.println("���� = "+ret.getString(2));
				System.err.println("���� = "+ret.getString(3));
			}
			//�ر�����
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
