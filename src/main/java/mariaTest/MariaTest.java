package mariaTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * ����MariaDB���ݿ����
 * @author Wendell
 *
 */
public class MariaTest {
	public static void main(String[] args) throws Exception {
		//��������
		Class.forName("org.mariadb.jdbc.Driver");
		//��������
		String url = "jdbc:mariadb://101.200.149.237:3306/test?useUnicode=true&characterEncoding=utf-8";
		Connection conn = DriverManager.getConnection(url, "root", "love@dream521.com");
		//����SQL���
		String sql = "select * from t_user";
		//ִ��SQL���
		PreparedStatement preStat = conn.prepareStatement(sql);
		ResultSet ret = preStat.executeQuery();
		//�õ��ܵ���������
		while(ret.next()){
			System.out.println("ID = "+ret.getInt(1));
			System.out.println("���� = "+ret.getString(2));
			System.err.println("���� = "+ret.getString(3));
		}
		//�ر�����
		ret.close();
		preStat.close();
		conn.close();
	}
}
