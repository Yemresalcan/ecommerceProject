package eCommerceProject.core.abstracts;

import eCommerceProject.entities.concretes.User;

public interface UserValidationService {
	boolean registerValidate(User user);
	
	boolean LoginValidate(String email, String password);
}
