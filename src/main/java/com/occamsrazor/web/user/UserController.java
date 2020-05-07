package com.occamsrazor.web.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.occamsrazor.web.util.Messenger;

@RestController
@RequestMapping("/users")
public class UserController{
	@Autowired UserService userSerivce;
	
	@PostMapping("")
	public Messenger post(@RequestBody User user){
		userSerivce.register(user);
	
		return Messenger.SUCCESS;
	}
	@GetMapping("")
	public List<User> list(){
		
		return userSerivce.findAll();
	}
	@GetMapping("/{userid}")
	public User detail(@PathVariable String userid ) {
		
		return userSerivce.findOne(userid);
	}
	@PutMapping("/{userid}")
	public Messenger update(@RequestBody User user){
		userSerivce.modify(user);
		return Messenger.SUCCESS;
	}
	@DeleteMapping("/{userid}")
	public Messenger delete(@RequestBody User user) {
		userSerivce.remove(user);
		return Messenger.SUCCESS;
	}
}





/*
public class UserController {
	@Autowired UserService userService;
	@PostMapping("/signup")
	public Messenger signup(@RequestBody User user) {
		System.out.println("userid "+ user);
		int count = userService.count();
	//	userService.saveFile(user);
		userService.add(user);
		//System.out.println(count);
	//	return (userService.count()== count+1)? Messenger.SUCCESS: Messenger.FAIL;
		return Messenger.SUCCESS;
	}
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody User user) {
		Map<String, Object> returnMap = new HashMap<>();
		User loginUser = userService.login(user);
		if(loginUser != null) {
			returnMap.put("user", loginUser);
			returnMap.put("messenger", Messenger.SUCCESS);
			
		}else {
			returnMap.put("messenger", Messenger.FAIL);
		}
		return returnMap;
	}
	@GetMapping("/detail/{userid}")
	public User detail(@PathVariable String userid) {
		System.out.println("detail 진입:::" + userid);
		return userService.detail(userid);
	}
	@PutMapping("/update")
	public Messenger update(@RequestBody User user) {
		System.out.println("update정보:::" + user);
		return (userService.update(user))? Messenger.SUCCESS: Messenger.FAIL;
	}
	@DeleteMapping("/remove/{userid}")
	public Messenger remove(@PathVariable String userid) {  //pathvariable는객체를 가져온다 (userid=)
	System.out.println("delete 정보:::"+userid);
	return (userService.remove(userid)) ? Messenger.SUCCESS: Messenger.FAIL;
	}
	
}
  
  public class UserController {
	@Autowired UserService userService;
	@PostMapping("")
	public Messenger signup(@RequestBody User user) {
		return Messenger.SUCCESS;
	}
	@GetMapping("")
	public List<user> list(){
	return null;
	}
	@GetMapping("/{userid}")
	public Admin detail(){
		return null;
	}
	@PutMapping("/{userid}")
	public Messenger put(@RequestBody User user) {
		return Messenger.SUCCESS
		}
	@DeleteMapping("/{userid}")
	public Messenger delete(@RequestBody User user){
	return Messenger.SUCCESS
	}
	
 
	*/