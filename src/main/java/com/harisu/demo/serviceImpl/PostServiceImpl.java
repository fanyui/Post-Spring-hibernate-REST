package com.harisu.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harisu.demo.dao.PostDAO;
import com.harisu.demo.entity.Post;
import com.harisu.demo.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	// need to inject customer dao
	@Autowired
	private PostDAO postDAO;
	
	@Override
	@Transactional
	public List<Post> getPosts() {
		return postDAO.getPosts();
	}

	@Override
	@Transactional
	public void savePost(Post post) {

		postDAO.savePost(post);
	}

	@Override
	@Transactional
	public Post getPost(int id) {
		
		return postDAO.getPost(id);
	}

	@Override
	@Transactional
	public void deletePost(int id) {
		
		postDAO.deletePost(id);
	}
}





