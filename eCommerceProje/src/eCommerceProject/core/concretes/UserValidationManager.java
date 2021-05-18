package eCommerceProject.core.concretes;

import java.util.regex.Pattern;

import eCommerceProject.core.abstracts.UserValidationService;
import eCommerceProject.entities.concretes.User;

public class UserValidationManager implements UserValidationService {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
	
	public UserValidationManager() {
		
	}

	
	
	@Override
	public boolean registerValidate(User user) {
		
		boolean result =isFirstNameLengthValid(user.getFirstName()) && isLastNameLengthValid(user.getLastName())
				&& isEmailFormatValid(user.getEmail()) && isPasswordLengthValid(user.getPassword())
				&& isAllFieldsFilled(user);
		
		return result;
	}






	private boolean isAllFieldsFilled(User user) {
		
		if (user.getFirstName().length() <= 0 || user.getLastName().length() <= 0 || user.getEmail().length() <= 0
				|| user.getPassword().length() <= 0) {
			return false;
		}
		return true;
	}
	



	private boolean isPasswordLengthValid(String password) {
		
		 	return password.length() > 5;
	}



	private boolean isEmailFormatValid(String email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	
	}



	private boolean isLastNameLengthValid(String lastName) {
		
		return lastName.length( )>1;
	}



	private boolean isFirstNameLengthValid(String firstName) {
		
		return firstName.length() > 1;
	}



	@Override
	public boolean LoginValidate(String email, String password) {
		
		boolean result= isEmailFormatValid(email) && isPasswordLengthValid(password);
		
		return result;
	}
	
	

}
