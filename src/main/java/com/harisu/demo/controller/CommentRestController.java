package com.harisu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harisu.demo.entity.Comment;
import com.harisu.demo.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentRestController {

	// autowire the CustomerService
	@Autowired
	private CommentService commentService;
	
	// add mapping for GET /comment
	@GetMapping("/comment")
	public List<Comment> getComments() {
		
		return commentService.getComments();
		
	}
	
	// add mapping for GET /comment/{id}
	
	@GetMapping("/comment/{commentId}")
	public Comment getComment(@PathVariable int id) {
		
		Comment comment = commentService.getComment(id);
		
		if (comment == null) {
			throw new NotFoundException("Comment id not found - " + id);
		}
		
		return comment;
	}
	
	// add mapping for POST /comment  - add new comment
	
	@PostMapping("/comment")
	public Comment addComment(@RequestBody Comment comment) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		comment.setId(0);
		
		commentService.saveComment(comment);
		
		return comment;
	}
	
	// add mapping for PUT /comment - update existing comment
	
	@PutMapping("/comment")
	public Comment updateComment(@RequestBody Comment comment) {
		
		commentService.saveComment(comment);
		
		return comment;
		
	}
	
	// add mapping for DELETE /customers/{customerId} - delete customer
	
	@DeleteMapping("/Comment/{id}")
	public String deleteComment(@PathVariable int id) {
		
		Comment tempComment = commentService.getComment(id);
		
		// throw exception if null
		
		if (tempComment == null) {
			throw new NotFoundException("Comment id not found - " + id);
		}
				
		commentService.deleteComment(id);
		
		return "Deleted Comment id - " + id;
	}
	
}


















