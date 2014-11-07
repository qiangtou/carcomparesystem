package cn.jiuling.comparesystem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jiuling.comparesystem.dao.UserDao;
import cn.jiuling.comparesystem.model.User;
import cn.jiuling.comparesystem.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public Boolean validUser(User user, String pwd) {
		return null != user && user.getStatus().intValue() == 1 && user.getPwd().equals(pwd);
	}

	public User findUser(String loginName) {
		return userDao.findByProperty("loginName", loginName);
	}
}
