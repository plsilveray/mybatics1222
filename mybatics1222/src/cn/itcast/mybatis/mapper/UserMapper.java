package cn.itcast.mybatis.mapper;



import java.util.List;

import cn.itcast.mybatis.po.T_userCustom;
import cn.itcast.mybatis.po.T_userQueryVo;
import cn.itcast.mybatis.po.t_user;
//根据输出类型确定
public interface UserMapper {
		//根据uid查用户信息
		public t_user findUserByUid(String uid) throws Exception ;
		//用户综合查询
		public List<T_userCustom> findT_userList(T_userQueryVo t_userQueryVo) throws Exception;
		//用户综合查询，计算分页？
		public int findT_userCount(T_userQueryVo t_userQueryVo) throws Exception;
		
}
