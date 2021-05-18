package eCommerceProject;

import eCommerceProject.GoogleAut.GoogleAuthManager;
import eCommerceProject.bussiness.abstracts.AuthService;
import eCommerceProject.bussiness.abstracts.UserService;
import eCommerceProject.bussiness.concretes.AuthManager;
import eCommerceProject.bussiness.concretes.UserManager;
import eCommerceProject.core.concretes.UserValidationManager;
import eCommerceProject.core.verification.EmailVerificationManager;
import eCommerceProject.dataAccess.concretes.HibernateUserDao;

public class Main {

	public static void main(String[] args) {
		UserService userservice = new UserManager(new HibernateUserDao());
		
		AuthService authService=new AuthManager(userservice,new UserValidationManager(),new EmailVerificationManager());
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓REGİSTER↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		
		authService.register(1, "Yunus", "Salcan", "yunusemresalcan@gmail.com", "01234231"); //Success
		System.out.println("\n------------------------------------------------------------\n");
		authService.register(2, "Yunus", "Salcan", "salcan", "123456"); // UnSuccess E-Mail
		System.out.println("\n------------------------------------------------------------\n");
		authService.register(3, "Yunus", "Salcan", "yunusemresalcan@gmail.com", "1234"); // Failed password
		System.out.println("\n------------------------------------------------------------\n");
		authService.register(4, "M", "V", "yunus.emresalcan@gmail.com", "1234"); // Failed Mail
		System.out.println("\n------------------------------------------------------------\n");
		authService.register(5, "Yunus", "Salcan", "yunusemresalcan.com", "1234231"); // Mail available

		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓LOGİN↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		authService.login("yunusemresalcan@gmail.com", "01234231");// Success
		System.out.println("\n------------------------------------------------------------\n");
		authService.login("mlh.vrlc@gmail.com", "1234567"); // User Unavailable
		System.out.println("\n------------------------------------------------------------\n");
		authService.login("", ""); // Failed email and password required

		AuthService googleAuthService = new GoogleAuthManager();
		googleAuthService.register(6, "Yunus", "Salcan", "yunusemresalcan@gmail", "01234231"); // Success
		System.out.println("\n-------------------------------------------------\n");
		googleAuthService.login("yunusemresalcan@gmail.com", "01234231");


	}

}
