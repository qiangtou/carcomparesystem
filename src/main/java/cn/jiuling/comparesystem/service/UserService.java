package cn.jiuling.comparesystem.service;

import cn.jiuling.comparesystem.model.User;

public interface UserService {

	public Boolean validUser(User user, String pwd);

	public User findUser(String loginName);

}
