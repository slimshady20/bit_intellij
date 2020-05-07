package com.occamsrazor.web.lost;

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

@Repository
public class LostDaoImpl implements LostDao {

	public void insert(Lost lost) {
		try {
			BufferedWriter writer = new BufferedWriter(
									new FileWriter(
									new File(Data.LOST_PATH.toString()+ Data.LIST + Data.CSV),true));
			writer.write(lost.toString());
			writer.newLine();
			writer.flush();
		} catch(Exception e) {
			System.out.println(Messenger.FILE_READ_ERROR);
		}
	}
	
	
	@Override
	public List<Lost> selectAll() {
		List<Lost> losts = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		try {
			File file = new File(Data.LOST_PATH+ "lost.csv");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message ="";
			while((message= reader.readLine())!= null) {
				temp.add(message);
			}
			reader.close();
		} catch(Exception e) {
			System.out.println("에러");
			
		}
		Lost l = null;
		for(int i=0; i<temp.size();i++) {
			l = new Lost();
			String[] arr = temp.get(i).split(",");
			l.setLostid(arr[0]);
			l.setName(arr[1]);
			l.setDate(arr[2]);
			l.setClassification(arr[3]);
			l.setLocation(arr[4]);
			losts.add(l);
		}
		return losts;
	}

	@Override
	public Lost selectOne(String lostid) {
		List<Lost> list = selectAll();
		Lost findLostId= null;
		for(Lost l: list) {
			if(lostid.equals(l.getLostid())) {
				findLostId = l;
				break;
			}
		}
		return findLostId;
	}

}
