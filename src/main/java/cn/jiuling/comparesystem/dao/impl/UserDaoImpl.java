package cn.jiuling.comparesystem.dao.impl;

import org.springframework.stereotype.Repository;

import cn.jiuling.comparesystem.dao.UserDao;
import cn.jiuling.comparesystem.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
