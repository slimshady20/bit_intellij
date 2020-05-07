package com.occamsrazor.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.occamsrazor.web.util.Data;
import com.occamsrazor.web.util.Messenger;

@Repository //객체
public class UserDaoImpl implements UserDao {

	@Override
	public void insert(User user) {
		System.out.println("3번" +  user);
		try {
			BufferedWriter writer = new BufferedWriter(
									new FileWriter(
									new File(Data.USER_PATH.toString()+ Data.LIST + Data.CSV),true));
				writer.write(user.toString());
				writer.newLine();
				writer.flush();
				System.out.println("4번"+ user);
		} catch(Exception e) {
			System.out.println(Messenger.FILE_READ_ERROR);
		}
		
	}

	@Override
	public List<User> selectAll() {
		List<User> list = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		try {
			File file = new File(Data.ADMIN_PATH + "user_list.csv");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message = "";
			while ((message = reader.readLine())!=null) {
				temp.add(message);
			}
			reader.close();
			
		}catch(Exception e) {
			System.out.println("에러");
			
		}
		User u = null;
		for(int i=0;i<temp.size();i++) {
			u= new User();
			String[] arr = temp.get(i).split(",");
			
			/*userid,passwd,name,ssn, addr,profile, email, phoneNumber, registerDate*/
			u.setUserid(arr[0]);
			u.setPasswd(arr[1]);
			u.setName(arr[2]);
			u.setSsn(arr[3]);
			u.setAddr(arr[4]);
			u.setProfile(arr[5]);
			u.setEmail(arr[6]);
			u.setPhoneNumber(arr[7]);
			u.setRegisterDate(arr[8]);
			list.add(u);
		}
	
		return list;
	}

	@Override
	public User selectOne(String userid) {
		List<User> list = selectAll();	
		User findUser = null;
		for(User u : list) {//향상된 for 문
			if(userid.equals(u.getUserid())) {
				findUser =u;
				break;
			}
		}
		return findUser;
	}
	


	
	

}
