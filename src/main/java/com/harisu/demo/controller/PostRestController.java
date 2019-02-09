package com.harisu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harisu.demo.entity.Comment;
import com.harisu.demo.entity.Like;
import com.harisu.demo.entity.Post;
import com.harisu.demo.entity.User;
import com.harisu.demo.service.CommentService;
import com.harisu.demo.service.PostService;
import com.harisu.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class PostRestController {

	// autowire the CustomerService
	@Autowired
	private PostService postService;
	
	// autowire the UserService
	@Autowired
	private UserService userService;
	
	// autowire the UserService
	@Autowired
	private CommentService commentService;
	
	// add mapping for GET /post
   // @CrossOrigin(origins = "http://localhost:3000")
    //@CrossOrigin(origins = "https://5809c399.ngrok.io/")
	//@CrossOrigin(origins = "https://5809c399.ngrok.io/", maxAge = 3600)
	@GetMapping("/post")
	public List<Post> getPosts() {
		
		return postService.getPosts();
		
	}
	
	// add mapping for GET /post/{id}
	
	@GetMapping("/post/{postId}")
	public Post getPost(@PathVariable int id) {
		
		Post post = postService.getPost(id);
		
		if (post == null) {
			throw new NotFoundException("Post id not found - " + id);
		}
		
		return post;
	}
	
	// add mapping for POST /post  - add new post
    
//        @CrossOrigin(origins = "https://5809c399.ngrok.io/")


	@PostMapping("/user/{id}/post")
	public Post addPost(@PathVariable int id, @RequestBody Post post) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		User user = userService.getUser(id);
		
		if (user == null) {
			throw new NotFoundException("user id not found - " + id);
		}
		
		post.setId(0);
		post.setUser(user);
		
		postService.savePost(post);
		
		return post;
	}
	
	// add mapping for PUT /post - update existing post
	
	@PutMapping("/post")
	public Post updatePost(@RequestBody Post post) {
		
		postService.savePost(post);
		
		return post;
		
	}
	
	// add mapping for DELETE /customers/{customerId} - delete customer
	
	@DeleteMapping("/Post/{id}")
	public String deletePost(@PathVariable int id) {
		
		Post tempPost = postService.getPost(id);
		
		// throw exception if null
		
		if (tempPost == null) {
			throw new NotFoundException("Post id not found - " + id);
		}
				
		postService.deletePost(id);
		
		return "Deleted Post id - " + id;
	}
	
	/* Comment for a post starts here
	 * all actions that happen to the comments of a particular post are implimented here below
	 * 
	 */
	// add mapping for POST /comment  - add new commment
	
	@PostMapping("/post/{id}/user/{userId}/comment")
	public Post addComment(@PathVariable int id, @PathVariable int userId, @RequestBody Comment comment) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		Post post = postService.getPost(id);
		User usr = userService.getUser(userId);
		
		if (post == null) {
			throw new NotFoundException("Post id not found - " + id);
		}
		
		if (usr == null) {
			throw new NotFoundException("User id not found - " + id);
		}
//		userService.getUser(id)
		comment.setId(0);
		comment.setPost(post);
		comment.setUser(usr);
		
		
		commentService.saveComment(comment);
		
		return postService.getPost(id);
	}
	
	// add mapping for DELETE /comment/{commentId} - delete comment
	
	@DeleteMapping("/comment/{id}")
	public String deleteComment(@PathVariable int id) {
		
		Comment tempComment = commentService.getComment(id);
		
		// throw exception if null
		
		if (tempComment == null) {
			throw new NotFoundException("Comment id not found - " + id);
		}
				
		commentService.deleteComment(id);
		
		return "Deleted Comment id - " + id;
	}
	
	
	/*
	 * liking and disliking apost happens here
	 * 
	 */
	
	@PostMapping("/post/{id}/user/{userId}/like")
	public Like like(@PathVariable int id, @PathVariable int userId, @RequestBody Like like) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		Post post = postService.getPost(id);
		User usr = userService.getUser(userId);
		
		if (post == null) {
			throw new NotFoundException("Post id not found - " + id);
		}
		
		if (usr == null) {
			throw new NotFoundException("User id not found - " + id);
		}
		like.setId(0);
		like.setUser(usr);
		like.setPost(post);

//		userService.getUser(id)
//		List<Like> likes = post.getLikes();
//		likes.add(like);
		post.addLike(like);

		postService.savePost(post);
		
		
		
		return like;
	}
	
	
	//todo impliment dislike
	
	
	
	//also do a search for certain period of days
	
}


















