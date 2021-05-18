package com.pagination.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagination.pagination.entity.Users;
import com.pagination.pagination.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}

	 @GetMapping
	    public ResponseEntity<List<Users>> getAllUsers(
	                        @RequestParam Integer pageNo, 
	                        @RequestParam Integer pageSize,
	                        @RequestParam String sortBy) 
	    {
	        List<Users> list = userService.getUsersList(pageNo, pageSize,sortBy);
	 
	        return new ResponseEntity<List<Users>>(list, new HttpHeaders(), HttpStatus.OK); 
	    }
	

}
