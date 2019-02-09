package com.harisu.demo.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harisu.demo.dao.PostDAO;
import com.harisu.demo.entity.Post;

@Repository
public class PostDAOImpl implements PostDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Post> getPosts() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Post> theQuery = 
				currentSession.createQuery("from Post order by createAt",
											Post.class);
		
		// execute query and get result list
		List<Post> posts = theQuery.getResultList();
				
		// return the results		
		return posts;
	}

	@Override
	public void savePost(Post post) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the post ... finally LOL
		currentSession.saveOrUpdate(post);
		
	}

	@Override
	public Post getPost(int id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Post post = currentSession.get(Post.class, id);
		
		return post;
	}

	@Override
	public void deletePost(int id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Post where id=:postId");
		theQuery.setParameter("postId", id);
		
		theQuery.executeUpdate();		
	}

}











