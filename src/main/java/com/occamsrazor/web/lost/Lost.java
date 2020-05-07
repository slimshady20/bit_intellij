package com.occamsrazor.web.lost;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Component
@Getter @Setter
public class Lost {
	private String lostid,name,date,classification,location;
	
	@Override
	public String toString() {
		return String.format
				("%s,$s,$s,$s,$s",lostid,name,date,classification,location);
	}
}
