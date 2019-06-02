/**
 * 
 */
package com.sajeev.sbsecurity.service;

import com.sajeev.sbsecurity.bean.CurrentUser;

/**
 * @author Dinesh.Rajput
 *
 */
public interface CurrentUserService {
	
	 boolean canAccessUser(CurrentUser currentUser, Long userId);
}
