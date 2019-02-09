/**
 * 
 */
package com.harisu.demo.dao;

import java.util.List;
import com.harisu.demo.entity.User;

/**
 * @author harisu
 *
 */
public interface UserDAO {
	public List<User> getUsers();

	public void saveUser(User user);

	public User getUser(int id);

	public void deleteUser(int id);
}
