package cn.itcast.mybatis.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.T_userCustom;
import cn.itcast.mybatis.po.T_userQueryVo;
import cn.itcast.mybatis.po.t_user;

public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception{
		//创建sqlSessionFactory
		
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
	//创建会话工厂，传入配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	@Test
	public void testFindUserByUid() throws Exception {
		//得到会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成代理对象,一个核心变化就是原先直接调方法，现在要先.getMapper
		UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
		//调用方法
		t_user t_user = UserMapper.findUserByUid("x");
		
		System.out.println(t_user);
		sqlSession.close();
	}
	//其他方法见pdf
	
	@Test
	public void testFindUserList() throws Exception {
		//得到会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成代理对象,一个核心变化就是原先直接调方法，现在要先.getMapper
		UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
		//创建包装对象，设置查询条件
		T_userQueryVo t_userQueryVo=new T_userQueryVo();
		T_userCustom t_userCustom = new T_userCustom();
		t_userCustom.setLoginname("li");
		t_userCustom.setUid("32DB3700D2564254982BC58B0E4D95BC");
		t_userQueryVo.setUserCustom(t_userCustom);
		//调用方法
		List<T_userCustom> list = UserMapper.findT_userList(t_userQueryVo);
		
		System.out.println(list);
		sqlSession.close();
	}
	@Test
	public void testFindUsercCount() throws Exception {
		//得到会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成代理对象,一个核心变化就是原先直接调方法，现在要先.getMapper
		UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
		//创建包装对象，设置查询条件
		T_userQueryVo t_userQueryVo=new T_userQueryVo();
		T_userCustom t_userCustom = new T_userCustom();
		
		t_userCustom.setUid("x");
		t_userQueryVo.setUserCustom(t_userCustom);
		//调用方法
		int result = UserMapper.findT_userCount(t_userQueryVo);
		
		System.out.println(result);
		sqlSession.close();
	}
}
