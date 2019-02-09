package com.harisu.demo.dao;

import java.util.List;

import com.harisu.demo.entity.Comment;
import com.harisu.demo.entity.Post;

public interface CommentDAO {

	public List<Comment> getComments();

	public void saveComment(Comment comment);

	public Comment getComment(int id);

	public void deleteComment(int id);
	
}
