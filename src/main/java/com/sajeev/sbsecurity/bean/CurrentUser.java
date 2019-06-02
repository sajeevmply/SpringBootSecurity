/**
 * 
 */
package com.sajeev.sbsecurity.bean;

import org.springframework.security.core.authority.AuthorityUtils;

import com.sajeev.sbsecurity.model.Users;
import com.sajeev.sbsecurity.role.Role;

/**
 * @author Dinesh.Rajput
 *
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Users user;
	
	public CurrentUser(Users user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public Users getUser() {
        return user;
    }
    
    public Long getId() {
        return user.getUserid();
    }

    public Role getRole() {
        return user.getRole();
    }
    
    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
}
}
