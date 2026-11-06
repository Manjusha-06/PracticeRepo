package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.User;
import com.klef.soa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;
	
	@Override
	public User addUser(User user) {
		
		return repo.save(user);
	}

	@Override
	public List<User> displayall() {
		
		return repo.findAll();
	}

	@Override
	public User displayById(Long id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public User updateuser(User user) {
		Optional<User> opt=repo.findById(user.getUid());
		if(opt.isPresent())
		{
			User u=opt.get();
			u.setEmail(user.getEmail());
			u.setName(user.getName());
			
			return repo.save(u);
		}
		else
		return null;
	}

	@Override
	public String deleteUser(Long id) {
		repo.findById(id);
		return "User deleted Successfully";
	}

}
