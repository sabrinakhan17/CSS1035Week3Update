/**
 * Group 4 - Spring 2021
 * @author Sabrina Khan, Dilpreet Kaur, Jasmilan Singh, Christopher Cruz, Tasha Gosine
 *
 */
public class TestBanking__S2021_SchmeelkBank {
	/**
	 * This main method was created to test the banking application.
	 * The program calls our checking account method once and 
	 * savings account methods twice and then tests out the following tests:
	 * 		Test 1: Create account
	 * 		Test 2: Deposit
	 * 		Test 3: Withdrawal
	 * 		Test 4: Withdrawal Error
	 * 		Test 5: Charge Fee
	 * 
	 * The purpose of this lab was to test the Custom Exceptions.
	 * 
	 * @param args Main Method Class
	 */
	public static void main(String[] args) {
		
		//Intro To Bank Application
		System.out.println("Welcome to Schmeelk's Savings Bank!\n");
		
		//Checking Account
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Test 1: Create Checking Account");
		Checking_S2021_SchmeelkBank c1 = new Checking_S2021_SchmeelkBank(1, "Checking 1", 1000);
		
		System.out.println("Checking Account:\n" + "Account Number\t" + "Account Name\t" + "Amount");
		c1.printCheckingAccountDetails();
		
		System.out.println("\nTest 2: Depositing $50");
		c1.depositChecking(50);
		c1.printCheckingAccountDetails();
		
		System.out.println("\nTest 3: Withdrawal $50");
		
		try {
			c1.withdrawlChecking(50);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		
		c1.printCheckingAccountDetails();
		
		System.out.println("\nTest 4: Print Error Message if Withdrawal Balance is Less Than Account Balance\n");
		
		try {
			c1.withdrawlChecking(2000);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		
		c1.printCheckingAccountDetails();
		System.out.println();
	
		
		//Savings Account 1 - below $2000(min amount for savings account)
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Test 1: Create Savings Account");
		Saving_S2021_SchmeelkBank s1 = new Saving_S2021_SchmeelkBank(1, "Savings 1", 1000);
	
		System.out.println("Test 5: Charge Fee if Balance is Less Than $2000, amount deposited is $" + s1.getsavingBalance());
		try {
			s1.fee();
		} catch (SavingFeeError e1) {
			System.out.println("\n"+e1);
		}
		
		System.out.println("\nSavings Account:\n" + "Account Number\t" + "Account Name\t" + "Amount");
		s1.printSavingsAccountDetails();
		
		System.out.println("\nTest 2: Depositing $1000");
		s1.depositSavings(1000);
		s1.printSavingsAccountDetails();
		
		System.out.println("\nTest 4: Print Error Message if Withdrawal Balance is Less Than Account Balance\n");
		try {
			s1.withdrawlSavings(5000);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		s1.printSavingsAccountDetails();
		
		System.out.println("\nTest 3: Withdrawal $50");
		try {
			s1.withdrawlSavings(50);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		s1.printSavingsAccountDetails();
		System.out.println();

		
		//Savings Account 2 - with over $2000(min amount for savings account)
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Test 1: Create Savings Account");
		Saving_S2021_SchmeelkBank s2 = new Saving_S2021_SchmeelkBank(2, "Savings 2", 3000);
		
		System.out.println("Test 5: Charge Fee if Balance is Less Than $2000, amount deposited is $" + s2.getsavingBalance());
		try {
			s2.fee();
		} catch (SavingFeeError e1) {
			System.out.println("\n"+e1);
		}
		System.out.println("\nSavings Account:\n" + "Account Number\t" + "Account Name\t" + "Amount");
		s2.printSavingsAccountDetails();
		
		System.out.println("\nTest 2: Depositing $1000");
		s2.depositSavings(1000);
		s2.printSavingsAccountDetails();
		
		System.out.println("\nTest 3: Withdrawal $500");
		try {
			s2.withdrawlSavings(500);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		s2.printSavingsAccountDetails();
		
		System.out.println("\nTest 4: Print Error Message if Withdrawal Balance is Less Than Account Balance\n");
		try {
			s2.withdrawlSavings(10000);
		} catch (InvalidWithdrawalAmount e) {
			System.out.println(e);
		}
		s2.printSavingsAccountDetails();
	}
}
