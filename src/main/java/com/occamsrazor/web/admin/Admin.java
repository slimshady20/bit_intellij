package com.occamsrazor.web.admin;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Component
@Getter @Setter
public class Admin {
	private String  userid,passwd,name,ssn, addr, 
	profile, email, phoneNumber, registerDate;
@Override
public String toString() {
return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", 
		userid,passwd,name,ssn, addr,profile, email, phoneNumber, registerDate);
}
public void setEmployNumber(String createEmployNumber) {
	// TODO Auto-generated method stub

}
}