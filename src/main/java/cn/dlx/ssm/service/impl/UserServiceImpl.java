package cn.dlx.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.dlx.ssm.mapper.UserMapper;
import cn.dlx.ssm.pojo.EasyUIResult;
import cn.dlx.ssm.pojo.User;
import cn.dlx.ssm.service.UserService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public EasyUIResult queryUserByPage(String pageNum, String pageSize) {
		Integer num = Integer.parseInt(pageNum);
		Integer size = Integer.parseInt(pageSize);
		PageHelper.startPage(num, size);
		List<User> list = userMapper.queryUserAll();
		EasyUIResult easyUIResult = new EasyUIResult();
		PageInfo<User> pageInfo = new PageInfo<>(list);
		easyUIResult.setRows(list);
		easyUIResult.setTotal(pageInfo.getTotal());
		return easyUIResult;
	}

	/*	@Override
		public EasyUIResult queryUserByPage(String pageNum, String pageSize) {
			Integer num = Integer.parseInt(pageNum);
			Integer size = Integer.parseInt(pageSize);
			List<User> list = userMapper.queryUserByPage((num - 1) * size, size);
			EasyUIResult easyUIResult = new EasyUIResult();
			easyUIResult.setRows(list);
			easyUIResult.setTotal(100l);
			return easyUIResult;
		}
	*/

	@Override
	public Integer saveUser(User user) {

		return this.userMapper.saveUser(user);
	}

	@Override
	public void deleteBatchUser(String[] ids) {
		/*if (ids != null && ids.length != 0) {
			for (String id : ids) {
				userMapper.deleteUserById(id);
			}
		}*/
		userMapper.deleteUserByIds(ids);
	}

	@Override
	public Integer updateUser(String id) {

		return null;
	}

	@Override
	public User queryUserById(String id) {

		return userMapper.queryUserById(Long.parseLong(id));
	}

}
