package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import cn.itcast.mybatis.po.t_user;

//入门程序.junit可以测试@Test方法，将jar包放到lib文件夹，然后build path.junit又称单元测试
//之后第一行弄个断点，再DEBUG AS junit就可以调试了，可以选第二个step over
public class MybatisFirst {
/*	public static void main(String args[]) throws IOException {
		MybatisFirst f =new MybatisFirst();
		f.findTuserByUid();
	}*/
	//根据uid查询t_user信息，得到一条记录
	@Test 
	public void findTuserByUid() throws IOException{
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件作为流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过SqlSession操作数据库
		//第一个参数：映射文件中的statement的uid，等于命名空间的那个uid
		//第二个参数：制定和映射文件中匹配parameterType类型的参数
		//返回结果：对应的POJO对象
		t_user t_user = sqlSession.selectOne("test.findUserByUid","x");//selectList接受的是list类型
		//打印对象的邮箱地址getEmail()
		System.out.println(t_user);
		//释放资源
		sqlSession.close();
	}
	//添加t_user
	@Test 
	public void insertTuser() throws IOException{
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件作为流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过SqlSession操作数据库
		//第一个参数：映射文件中的statement的uid，等于命名空间的那个uid
		//第二个参数：制定和映射文件中匹配parameterType类型的参数
		//插入用户对象
		t_user user = new t_user();
		user.setEmail("91523@qq.com");
		user.setLoginname("yan");
		user.setLoginpass("1234");
		user.setActivationCode("x");
		user.setStatus(1);
		user.setUid("xxyan");
		//int t = sqlSession.insert("test.insertTuser", user);
		//提交事务
		sqlSession.commit();
		System.out.println(user.getUid());
		//自增主键，sql自带的函数LAST_INSERT_ID()获取上一条添加记录的主键
		//非自增主键，用uuid()方法
		//释放资源
		sqlSession.close();
	}
	//删除，传入主键，执行删除
	//更新，更新传入的是一整个pojo对象，根据主键查找要更新的记录
	
	//mybatis是根据ONGL来获得对象的属性值：OGNL是
	/*Object-Graph Navigation Language的缩写，它是一种功能强大的表达式语言，
	通过它简单一致的表达式语法，可以存取对象的任意属性，调用对象的方法，遍历整个对象的结构图，实现字段类型转化等功能。
	 * ｈｉｂｅｒｎａｔｅ是一个标准的orm框架，应用场景需求变化不多的中小型项目，如后台管理系统　，ｅｒｐ、ｏａ
	 * mybatis入门门槛低，可以自己写sql，常用于互联网公司，如商城经常搞活动，经常变化需求（经常加班）
	 * 企业技术选型原则是低成本，高会操作，根据技术组力量选择
	 * 
	
	*/
}
