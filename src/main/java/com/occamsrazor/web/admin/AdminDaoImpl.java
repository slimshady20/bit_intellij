package com.occamsrazor.web.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.occamsrazor.web.util.Data;
import com.occamsrazor.web.util.Messenger;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Override
	public void insert(Admin admin) {
		System.out.println("3번" + admin);
		try {
			BufferedWriter writer = new BufferedWriter(
									new FileWriter(
									new File(Data.ADMIN_PATH.toString()+ Data.LIST + Data.CSV),true));
			writer.write(admin.toString());
			writer.newLine();
			writer.flush();
			System.out.println("4번"+ admin);
		} catch(Exception e) {
			System.out.println(Messenger.FILE_READ_ERROR);
		}
		
	}

	@Override
	public List<Admin> selectAll() {
		List<Admin>	list = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		try {
			File file = new File(Data.ADMIN_PATH+ "admin_list.csv");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message ="";
			while((message = reader.readLine())!= null) {
				temp.add(message);
			}
			reader.close();
			
		} catch(Exception e) {
			System.out.println("에러");
		}
		Admin a = null;
		for(int i =0; i< temp.size(); i++) {
			a = new Admin();
			String[] arr= temp.get(i).split(",");
			a.setUserid(arr[0]);
			a.setPasswd(arr[1]);
			a.setName(arr[2]);
			a.setSsn(arr[3]);
			a.setAddr(arr[4]);
			a.setProfile(arr[5]);
			a.setEmail(arr[6]);
			a.setPhoneNumber(arr[7]);
			a.setRegisterDate(arr[8]);
			list.add(a);
		}
		return list;
	}
	
	@Override
	public Admin selectOne(String userid) {
		List<Admin> list = selectAll();
		Admin findAdmin =null;
		for(Admin a: list) {
			if(userid.equals(a.getUserid())) {
				findAdmin = a;
				break;
			}
			}
		return findAdmin;
	}
			
	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	

}
