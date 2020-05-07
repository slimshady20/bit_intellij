package com.occamsrazor.web.user;

import java.util.List;

public interface UserDao {

	public List<User> selectAll();

	void insert(User user);

	public User selectOne(String userid);

	

}
