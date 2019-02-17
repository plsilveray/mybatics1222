package cn.itcast.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
							//当前mylipse没有自动保存修改的设置
public class JDBCtest {

	public static void main(String[] args) {
		Connection conection = null;
		//预编译的，能在下次运行结果相同时不编译，提高性能
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("hello");
		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//通过驱动管理类获取数据库连接
			conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/goods?characterEncoding=utf-8"
					,"root","1234");
			//定义ＳＱＬ语句？表示占位符
			String sql = "select * from t_user where loginname = ?";
			//获取预处理statement
			preparedStatement = conection.prepareStatement(sql);
			//设置参数，第一个参数为ＳＱＬ语句中参数的问好，第二个参数为设置的参数值
			preparedStatement.setString(1, "wangWu");
			//向数据库发出sql执行查询，查询出结果集
			resultSet = preparedStatement.executeQuery();
			//遍历查询结果集
			while(resultSet.next()) {
				System.out.println(resultSet.getString("uid")+" "+resultSet.getString("loginname"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(resultSet!=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conection!=null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
/*
 * 总结 这是个最基础的ＪＤＢＣ
 * 弊端在于死代码，死参数
 * ｍｙＢａｔｉｓ能用自己的映射来代理,还有封装成对象等类型的功能
 * 会话工厂　－－　会话　－－　执行器　－－　封装对象（简单对象　哈希　ＰＯＪＯ自定义）
 * 控制　见day1 第３　集
 *
*/