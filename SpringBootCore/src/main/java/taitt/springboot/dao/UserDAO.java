package taitt.springboot.dao;

import java.util.List;

import taitt.springboot.entity.User;

public interface UserDAO {
	List<User> getAllUser();
	User getUserById(long id);
	void addUser(User user);
	void updateUser(User user);
	void removeUser(int id);
}
