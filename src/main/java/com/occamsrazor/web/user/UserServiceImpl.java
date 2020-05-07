package com.occamsrazor.web.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserDao userDao;
	

	
	@Override
	public List<User> findAll() {
		
		return userDao.selectAll();
	}



	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public User findOne(String userid) {
		return userDao.selectOne(userid);
	}



	@Override
	public void modify(User user) {
		
		
	}



	@Override
	public void remove(User user) {
		// TODO Auto-generated method stub
		
	}


}