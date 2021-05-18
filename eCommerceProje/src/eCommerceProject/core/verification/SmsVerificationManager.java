package eCommerceProject.core.verification;

import java.util.Random;
import java.util.Scanner;

import eCommerceProject.entities.concretes.User;

public class SmsVerificationManager implements VerificationService {

	@Override
	public boolean verificate(User user) {
		Scanner scanner = new Scanner(System.in);
		char isDecision = 'n';
		System.out.println(
				user.getFirstName() + 
				"Do you want to enter the verification code from the person's phone? (Y / N)");
		isDecision = scanner.next().charAt(0);

		if (isDecision == 'y' || isDecision == 'Y') {
			Random random = new Random();
			int randomInteger, ýAmNotARobot, count = 0;

			do {
				randomInteger = random.nextInt(999999 - 100000 + 1) + 100000;

				System.out.println(
						"To verify your account, enter the 6-digit number received by the phone:\n ==>  " + randomInteger);
				ýAmNotARobot = scanner.nextInt();
				count++;
				if (count == 4) {
					System.out.println(
							"We are currently unable to verify your account due to many wrong attempts.\nPlease try again later.");
					scanner.close();
					return false;
				}
			} while (!(ýAmNotARobot == randomInteger) && count < 4);
			System.out.println("Your account has been verified.");
			user.setVerified(true);
			scanner.close();
			return true;

		}
		scanner.close();
		return false;
	}
}