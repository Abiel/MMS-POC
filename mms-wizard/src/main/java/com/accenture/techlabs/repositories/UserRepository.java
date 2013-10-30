/**
 * 
 */
package com.accenture.techlabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.techlabs.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

}
