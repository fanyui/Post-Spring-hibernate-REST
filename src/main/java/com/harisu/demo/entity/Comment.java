package com.harisu.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	/**
	 * @return the user
	 */
//	public User getUser() {
//		return user;
//	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the post
	 */
//	public Post getPost() {
//		return post;
//	}

	/**
	 * @param post the post to set
	 */
	public void setPost(Post post) {
		this.post = post;
	}

	/**
	 * @return the like
	 */
//	public Boolean getLike() {
//		return like;
//	}
//
//	/**
//	 * @param like the like to set
//	 */
//	public void setLike(Boolean like) {
//		this.like = like;
//	}

	@Column(name="comment")
	private String comment;

//	@Column(name="likes")
//	private Boolean like;
//	
	@Column(name="create_at")
	private Date createAt;
	
	
	@Column(name="update_at")
	private Date updateAt;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param name the name to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}



	/**
	 * @return the createAt
	 */
	public Date getCreateAt() {
		return createAt;
	}

	/**
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	/**
	 * @return the updateAt
	 */
	public Date getUpdateAt() {
		return updateAt;
	}

	/**
	 * @param updateAt the updateAt to set
	 */
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Comment() {
		
	}

		
}





