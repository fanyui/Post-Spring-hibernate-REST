package com.harisu.demo.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harisu.demo.dao.CommentDAO;
import com.harisu.demo.dao.PostDAO;
import com.harisu.demo.entity.Comment;
import com.harisu.demo.entity.Post;

@Repository
public class CommentDAOImpl implements CommentDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Comment> getComments() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Comment> theQuery = 
				currentSession.createQuery("from Comment order by createAt",
						Comment.class);
		
		// execute query and get result list
		List<Comment> comments = theQuery.getResultList();
				
		// return the results		
		return comments;
	}

	@Override
	public void saveComment(Comment comment) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the Comment ... finally LOL
		currentSession.saveOrUpdate(comment);
		
	}

	@Override
	public Comment getComment(int id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Comment comment = currentSession.get(Comment.class, id);
		
		return comment;
	}

	@Override
	public void deleteComment(int id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Comment where id=:commentId");
		theQuery.setParameter("commentId", id);
		
		theQuery.executeUpdate();		
	}


}











