package eCommerceProject.GoogleAut;

import eCommerceProject.bussiness.abstracts.AuthService;

public class GoogleAuthManager implements AuthService{

	@Override
	public void register(int id, String firstName, String lastname, String email, String password) {
		System.out.println(" With Google account :  "+email);
		
	}

	@Override
	public void login(String email, String password) {
		System.out.println("Logged in with google  : "+email);
		
	}

}
