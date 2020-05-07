package com.occamsrazor.web.lost;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public interface LostDao {
	public List<Lost> selectAll();
	public void insert(Lost lost);
	public Lost selectOne(String lostid);
}
