package eCommerceProject.bussiness.concretes;

import eCommerceProject.bussiness.abstracts.AuthService;
import eCommerceProject.bussiness.abstracts.UserService;
import eCommerceProject.core.abstracts.UserValidationService;
import eCommerceProject.core.verification.VerificationService;
import eCommerceProject.entities.concretes.User;

public class AuthManager  implements AuthService{
	
	UserService userService;
	UserValidationService userValidationService;
	VerificationService verificationService;
	
	
	public AuthManager() {
		
	}
	public AuthManager(UserService userService, UserValidationService userValidationService,VerificationService verificationService) {
		super();
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.verificationService = verificationService;
	}

	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {User userToRegister = new User(id, firstName, lastName, email, password, false);

		if (!this.userValidationService.registerValidate(userToRegister)) {
			System.out.println("Check your user information!");
			return;
		}

		if (!checkIfUserExists(email)) {
			System.out.println("Registration failed. Another member is available with this email..");
			return;
		}

		if (!this.verificationService.verificate(userToRegister)) {
			System.out.println("Verification has been canceled.");
		}

		userService.add(userToRegister);
	}

	private boolean checkIfUserExists(String email) {
		return this.userService.getByMail(email) == null;
		
	}
	@Override
	public void login(String email, String password) {

		if (!this.userValidationService.LoginValidate(email, password)) {
			System.out.println("Check your user information!");
			return;
		}

		User userToLogin = userService.getByEmailAndPassword(email, password);

		if (userToLogin == null) {
			System.out.println("Login failed. Your e-mail or password information is incorrect.");
			return;
		}

		if (!checkIfUserVerified(userToLogin)) {
			System.out.println("Login failed. You have not verified your membership.");
			return;
		}

		System.out
				.println("Login successful. Welcome " + userToLogin.getFirstName() + " " + userToLogin.getLastName());

	}
	private boolean checkIfUserVerified(User user) {
		return user.isVerified();
		
	}
	
	
}


