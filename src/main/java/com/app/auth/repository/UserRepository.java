package com.app.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.auth.model.PocUser;

//public interface StudentRepository extends JpaRepository<Student, Long>{
	public interface UserRepository extends JpaRepository<PocUser, Long>{
		PocUser findByUserName(String username);
		PocUser findByUserNameUserType(String username, String usertype);
}
