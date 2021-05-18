package eCommerceProject.bussiness.abstracts;

import java.util.List;

import eCommerceProject.entities.concretes.User;

public interface UserService {
	void add(User user);

	void update(User user);

	void delete(User user);

	User getById(int id);

	User getByMail(String email);

	User getByEmailAndPassword(String email, String password);

	List<User> getAll();

}
