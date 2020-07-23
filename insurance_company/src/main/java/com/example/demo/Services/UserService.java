package com.example.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;

@Service
public class UserService {
 @Autowired
 private UserRepository userRepository;
 public User getUserByUsername(String username)
	{  	
    	 return userRepository.findByUsername(username);
	 
    }
}
