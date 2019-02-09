package com.harisu.demo.service;

import java.util.List;

import com.harisu.demo.entity.User;

public interface UserService {
	public List<User> getUsers();

	public void saveUser(User user);

	public User getUser(int id);

	public void deleteUser(int id);
}
