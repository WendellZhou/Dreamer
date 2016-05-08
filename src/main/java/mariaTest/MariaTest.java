package mariaTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 连接MariaDB数据库举例
 * @author Wendell
 *
 */
public class MariaTest {
	public static void main(String[] args) throws Exception {
		//加载驱动
		Class.forName("org.mariadb.jdbc.Driver");
		//建立连接
		String url = "jdbc:mariadb://101.200.149.237:3306/test?useUnicode=true&characterEncoding=utf-8";
		Connection conn = DriverManager.getConnection(url, "root", "love@dream521.com");
		//创建SQL语句
		String sql = "select * from t_user";
		//执行SQL语句
		PreparedStatement preStat = conn.prepareStatement(sql);
		ResultSet ret = preStat.executeQuery();
		//得到总的数据总数
		while(ret.next()){
			System.out.println("ID = "+ret.getInt(1));
			System.out.println("姓名 = "+ret.getString(2));
			System.err.println("密码 = "+ret.getString(3));
		}
		//关闭连接
		ret.close();
		preStat.close();
		conn.close();
	}
}
