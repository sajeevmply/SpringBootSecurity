/**
 * 
 */
package com.sajeev.sbsecurity.model;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Dinesh.Rajput
 *
 */
public interface UserRepository extends CrudRepository<Users, Long>{
	
	Users findOneByEmail(String email);
}
