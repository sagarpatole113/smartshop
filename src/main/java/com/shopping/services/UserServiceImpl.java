package com.shopping.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.dao.UserDao;
import com.shopping.entities.User;
@Transactional
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDao userdao;

	@Override
	public User findByEmail(String email) {
		
		return userdao.findByEmail(email);
	}

	@Override
	public User authenticate(String email, String password) {
		
		User user = userdao.findByEmail(email);
		if(user != null && passwordEncoder.matches(password, user.getPassword())){
		return user;
		}
		return null;
	}

	@Override
	public User save(User user) {
		String encPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encPassword);
		return userdao.save(user);
	}

	@Override
	public User findById(int id) {
		Optional<User> user = userdao.findById(id);
		return user.orElse(null);
	}

	@Override
	public boolean deleteById(int id) {
		
		if(userdao.existsById(id)) {
			userdao.deleteById(id);
			return true;
		}
		return false;
		
	}

}
