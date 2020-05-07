package com.occamsrazor.web.lost;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/losts")
public class LostController {
	@Autowired LostService lostService;
	
	@GetMapping("")
	public List<Lost> list(){

		return lostService.findAll();
	}
	@GetMapping("/{lostid}")
	public Lost detail(@PathVariable String lostid) {
		
		return lostService.findOne(lostid);
		
	}
}
