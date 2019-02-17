package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.po.t_user;

public interface UserMapper {
		//根据uid查用户信息
		public t_user findUserByUid(String uid) throws Exception ;
		
		
}
