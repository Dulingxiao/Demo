package cn.dlx.ssm.service;

import cn.dlx.ssm.pojo.EasyUIResult;
import cn.dlx.ssm.pojo.User;

public interface UserService {

	EasyUIResult queryUserByPage(String pageNum, String pageSize);

	Integer saveUser(User user);

	void deleteBatchUser(String[] ids);

	Integer updateUser(String id);

	User queryUserById(String id);

}
