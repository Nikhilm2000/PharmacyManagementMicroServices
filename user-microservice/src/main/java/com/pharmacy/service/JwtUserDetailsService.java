package com.pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pharmacy.model.UserDao;
import com.pharmacy.model.UserDto;
import com.pharmacy.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDao user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public UserDao save(UserDto user) {
		UserDao newUser = new UserDao();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setUserPhNumber(user.getUserPhNumber());
		newUser.setUserEmail(user.getUserEmail());
		return userDao.save(newUser);
	}

	public List<UserDao> findAll() {
		// TODO Auto-generated method stub
		return (List<UserDao>) userDao.findAll();
	}
	public void deleteUser(Long userID) {
	userDao.deleteById(userID);
}

public UserDao updateUser(UserDao user) {
	userDao.save(user);
	return user;
}

public UserDao getById(Long userID) {
	// TODO Auto-generated method stub
	return userDao.getById(userID);
}


}