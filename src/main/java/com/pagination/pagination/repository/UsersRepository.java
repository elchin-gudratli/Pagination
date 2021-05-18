package com.pagination.pagination.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pagination.pagination.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

	   @Query(value = "select u from Users u where u.name like %:name%")
	   public List<Users> findByName(@Param("name") String name, Pageable pageable);
}
