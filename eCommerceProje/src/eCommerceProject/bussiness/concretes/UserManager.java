package eCommerceProject.bussiness.concretes;

import java.util.List;

import eCommerceProject.bussiness.abstracts.UserService;
import eCommerceProject.dataAccess.abstracts.UserDao;
import eCommerceProject.entities.concretes.User;

public class UserManager implements UserService{
	UserDao userDao;

	public UserManager(UserDao userdao) {
		super();
		this.userDao=userdao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		System.out.println("User successfully created");
		
	}

	@Override
	public void update(User user) {
	userDao.update(user);
	System.out.println("User informations update ");
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		System.out.println("User delete ! ");
		
	}

	@Override
	public User getById(int id) {
		
		return userDao.getById(id);
	}

	@Override
	public User getByMail(String email) {
		
		return userDao.getByMail(email);
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		return userDao.getByEmailAndPassword(email,password);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

}
