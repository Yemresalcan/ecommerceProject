package eCommerceProject.core.verification;



import java.util.Random;
import java.util.Scanner;

import eCommerceProject.entities.concretes.User;

public class EmailVerificationManager implements VerificationService {

	@Override
	public boolean verificate(User user) {
		Scanner scanner = new Scanner(System.in);
		char isDecision='n';
		System.out.println(user.getEmail()+"We sent a correct code to your address. Do you want to verify your account? (Y / N) ");
			isDecision=scanner.next().charAt(0);
			
			if (isDecision=='y'|| isDecision=='Y') {
				Random random=new Random();
				int randomInteger,iAmNotRobot,count=0;
			
				
				do {
					randomInteger=random.nextInt(999999-100000+1)+100000;
					System.out.println("To verify your account, enter the 6-digit number sent to your email.\n ==>  "+randomInteger);
					iAmNotRobot=scanner.nextInt();
					count++;
					
					if (count==4) {
						System.out.println("We are currently unable to verify your account due to many wrong attempts.\nPlease try again later.");
						scanner.close();
						return false;
					}
					
				} while (!(iAmNotRobot == randomInteger) && count < 4);
				System.out.println("Your account has been verified");
				user.setVerified(true);
				scanner.close();
				return true;
				
			}
			
		scanner.close();
		return false;
	}

}
