package com.harisu.demo.service;

import java.util.List;

import com.harisu.demo.entity.Post;

public interface PostService {

	public List<Post> getPosts();

	public void savePost(Post post);

	public Post getPost(int id);

	public void deletePost(int id);
	
}
