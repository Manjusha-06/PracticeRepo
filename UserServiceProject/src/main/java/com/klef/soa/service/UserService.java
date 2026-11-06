package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.User;

public interface UserService {

	User addUser(User user);

	List<User> displayall();

	User displayById(Long id);

	User updateuser(User user);

	String deleteUser(Long id);

}
