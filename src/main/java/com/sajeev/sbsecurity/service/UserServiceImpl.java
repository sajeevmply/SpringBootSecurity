/**
 * 
 */
package com.sajeev.sbsecurity.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sajeev.sbsecurity.bean.UserBean;
import com.sajeev.sbsecurity.model.Users;
import com.sajeev.sbsecurity.model.UserRepository;

/**
 * @author Dinesh.Rajput
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Users getUserById(long id) {
		LOGGER.debug("Getting user={}", id);
		return userRepository.findOne(id);
	}

	@Override
	public Users getUserByEmail(String email) {
		LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
		return userRepository.findOneByEmail(email);
	}

	@Override
	public Collection<Users> getAllUsers() {
		LOGGER.debug("Getting all users");
		return (Collection<Users>) userRepository.findAll();
	}

	@Override
	public Users create(UserBean userBean) {
		Users user = new Users();
		user.setUsername(userBean.getUsername());
        user.setEmail(userBean.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userBean.getPassword()));
        user.setRole(userBean.getRole());
        return userRepository.save(user);
	}

}
