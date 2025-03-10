package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepository;

	public List<User> getUser() {

		return userrepository.findAll();
	}

	public User addUser(User us) {

		return userrepository.save(us);
	}

	public User loginUser(User us) {
		return userrepository.findUserByEmailIdAndPassword(us.getEmailId(), us.getPassword());
    }

	
}
