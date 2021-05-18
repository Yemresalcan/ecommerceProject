package eCommerceProject.bussiness.abstracts;

public interface AuthService {
	void register(int id, String firstName, String lastname,String email,String password);
	
	void login(String email,String password);

}
