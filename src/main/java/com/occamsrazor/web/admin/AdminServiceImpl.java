package com.occamsrazor.web.admin;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AdminServiceImpl implements AdminService{
	@Autowired AdminDao adminDao; 
	
	@Override
	public void register(Admin admin) {
		// employNumber,passwd,name,position,profile,email,phoneNumber,registerDate;
		System.out.println("2번" + admin);
		admin.setEmployNumber(createEmployNumber());	// 4자리 랜덤수
		admin.setPasswd("1");
		admin.setRegisterDate(createCurrentDate());	// 자바에서 현재날짜 logic 
		adminDao.insert(admin);
		
	}

	private String createCurrentDate() {
	
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	//	LocalDate today = LocalDate.now();
	//	return today.toString();
	}

	private String createEmployNumber() {
	//	System.out.println("번호: "+   String.format("%04d", Math.random()*10000+1000));
		String startNum ="";
		for(int i=0; i<4;i++) {
			startNum += String.valueOf((int)(Math.random()*10));
		}
		return startNum;
	//	return String.format("%04d", Math.random()*10000+1000);
	}

	@Override
	public List<Admin> findAll() {
		
		return adminDao.selectAll();
	}

	@Override
	public Admin findOne(String employNumber) {
		// TODO Auto-generated method stub
		return  adminDao.selectOne(employNumber);
	}

	@Override
	public void modify(Admin admin) {
		adminDao.update(admin);
		
	}

	@Override
	public void remove(Admin admin) {
		adminDao.delete(admin);
		
	}
	
}

