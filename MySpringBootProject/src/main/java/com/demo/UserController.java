package com.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public String getUsers(@RequestParam (value="page") int page,@RequestParam (value="limit") int limit)
	{
		return "HTTP GET request was sent for page:" +page+ " and limit is:" +limit;
	}
	
	@GetMapping(path="/{userID}")//path parameter
	public String getUser(@PathVariable String userID)
	{
		return "HTTP GET request was sent for user ID:"+userID;
	}
		
	@PostMapping
	public String createUser()
	{
		return "HTTP POST request was sent";
	}
	
	@PutMapping
	public String updateUser()
	{
		return "HTTP PUT request was sent";
	}
	
	@DeleteMapping
	public String deleteUser()
	{
		return "HTTP DELETE request was sent";
	}

}
