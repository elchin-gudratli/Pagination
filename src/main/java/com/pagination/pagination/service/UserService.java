package com.pagination.pagination.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pagination.pagination.entity.Users;

public interface UserService {

	//List<Users> getUsersList(Integer pageNo, Integer pageSize);

	List<Users> getUsersList(Integer pageNo, Integer pageSize, String sortBy);
	

}
