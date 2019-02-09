/**
 * 
 */
package com.harisu.demo.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harisu.demo.dao.UserDAO;
import com.harisu.demo.entity.User;
import com.harisu.demo.entity.User;

/**
 * @author harisu
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.harisu.demo.dao.UserDAO#getUsers()
	 */
	@Override
	public List<User> getUsers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<User> theQuery = 
				currentSession.createQuery("from User order by createAt",
											User.class);
		
		// execute query and get result list
		List<User> users = theQuery.getResultList();
				
		// return the results		
		return users;
	}

	@Override
	public void saveUser(User user) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the user ... finally LOL
		currentSession.saveOrUpdate(user);
		
	}

	@Override
	public User getUser(int id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		User user = currentSession.get(User.class, id);
		
		return user;
	}

	@Override
	public void deleteUser(int id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from User where id=:userId");
		theQuery.setParameter("userId", id);
		
		theQuery.executeUpdate();		
	}


}
