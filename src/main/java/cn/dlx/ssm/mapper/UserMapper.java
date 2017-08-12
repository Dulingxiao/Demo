package cn.dlx.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dlx.ssm.pojo.User;

public interface UserMapper {

	public User queryUserById(Long id);

	public List<User> queryUserByPage(@Param("num") Integer num, @Param("size") Integer size);

	public List<User> queryUserAll();

	public Integer saveUser(User user);

	public void deleteUserById(String id);

	public void deleteUserByIds(@Param("ids") String[] ids);
}
