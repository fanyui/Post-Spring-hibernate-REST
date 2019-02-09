/**
 * 
 */
package com.harisu.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harisu.demo.dao.UserDAO;
import com.harisu.demo.entity.User;
import com.harisu.demo.service.UserService;

/**
 * @author harisu
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	/* (non-Javadoc)
	 * @see com.harisu.demo.service.UserService#getUsers()
	 */
	@Override
	@Transactional

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDAO.getUsers();
	}

	/* (non-Javadoc)
	 * @see com.harisu.demo.service.UserService#saveUser(com.harisu.demo.entity.User)
	 */
	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);

	}

	/* (non-Javadoc)
	 * @see com.harisu.demo.service.UserService#getUser(int)
	 */
	@Override
	@Transactional
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userDAO.getUser(id);
	}

	/* (non-Javadoc)
	 * @see com.harisu.demo.service.UserService#deleteUser(int)
	 */
	@Override
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);

	}

}
