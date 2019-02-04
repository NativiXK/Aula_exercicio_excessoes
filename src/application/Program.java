package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

import models.entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			sc.next();
			System.out.print("Initial balance: ");
			double initBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, initBalance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double withdraw = sc.nextDouble();
			
			account.withdraw(withdraw);
			
			
		} catch (AccountException e) {
			System.out.println("Withdraw error : " + e.getMessage());
		} catch (InputMismatchException e ) { 
			System.out.println("Runtime error");
		}
		
		
		sc.close();
	}

}
