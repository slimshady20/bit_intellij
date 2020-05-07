package com.occamsrazor.web.admin;

import java.util.List;

public interface AdminDao {

	public void insert(Admin admin);

	public List<Admin> selectAll();

	public void update(Admin admin);

	public void delete(Admin admin);

	public Admin selectOne(String employNumber);

}
