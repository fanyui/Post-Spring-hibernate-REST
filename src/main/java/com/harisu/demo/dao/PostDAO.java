package com.harisu.demo.dao;

import java.util.List;

import com.harisu.demo.entity.Post;

public interface PostDAO {

	public List<Post> getPosts();

	public void savePost(Post post);

	public Post getPost(int id);

	public void deletePost(int id);
	
}
