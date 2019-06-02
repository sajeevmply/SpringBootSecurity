/**
 * 
 */
package com.sajeev.sbsecurity.service;

import java.util.Collection;

import com.sajeev.sbsecurity.bean.UserBean;
import com.sajeev.sbsecurity.model.Users;

/**
 * @author Dinesh.Rajput
 *
 */
public interface UserService {
	
	Users getUserById(long id);

    Users getUserByEmail(String email);

    Collection<Users> getAllUsers();

    Users create(UserBean userBean);
}
