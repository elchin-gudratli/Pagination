package com.pagination.pagination.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pagination.pagination.entity.Users;
import com.pagination.pagination.repository.UsersRepository;
import com.pagination.pagination.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final UsersRepository usersRepository;
	
	public UserServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	

	@Override
	public List<Users> getUsersList(Integer pageNo, Integer pageSize,String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sortBy).descending());
		 
        Page<Users> pagedResult = usersRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Users>();
        }

	}
	
	
/*
 * Find with Name
	@Override
	public List<Users> getUsersList(Integer pageNo, Integer pageSize,String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sortBy));
		 
		List<Users> slicedResult = usersRepository.findByName(" ", paging); 
		 
        if(slicedResult.size()>0) {
            return slicedResult;
        } else {
            return new ArrayList<Users>();
        }
	}

*/

}
