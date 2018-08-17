package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static BasicDataSource dataSource;
	static {
		//读取配置文件信息
		Properties prop = new Properties();
		//获取文件输入流
		InputStream isp=DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//把文件加载到prop对象中
		try {
			prop.load(isp);
			String driver=prop.getProperty("driver");
			String url=prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			String initSize=prop.getProperty("initSize");
			String maxSize=prop.getProperty("maxSize");
			
			System.out.println(""+driver+url+username+password+initSize+maxSize);
			//创建连接池
			dataSource=new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setInitialSize(Integer.parseInt(initSize));
			dataSource.setMaxActive(Integer.parseInt(maxSize));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static Connection getConn() throws SQLException {
		return dataSource.getConnection();
		
	}
	public static void close (ResultSet rs,Statement stat,Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stat!=null) {
				stat.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
