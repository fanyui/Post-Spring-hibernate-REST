package com.harisu.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harisu.demo.dao.CommentDAO;
import com.harisu.demo.entity.Comment;
import com.harisu.demo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	// need to inject customer dao
	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	@Transactional
	public List<Comment> getComments() {
		return commentDAO.getComments();
	}

	@Override
	@Transactional
	public void saveComment(Comment comment) {

		commentDAO.saveComment(comment);
	}

	@Override
	@Transactional
	public Comment getComment(int id) {
		
		return commentDAO.getComment(id);
	}

	@Override
	@Transactional
	public void deleteComment(int id) {
		
		commentDAO.deleteComment(id);
	}
}





