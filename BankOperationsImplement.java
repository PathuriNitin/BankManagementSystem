package com.bank;

import java.util.Scanner;

public class BankOperationsImplement implements BankOperations
{

	Scanner sc = new Scanner(System.in);
	
	
	@Override
	public void createAccount() {
		System.out.println("ENTER ACCOUNT NUMBER:");
		long accNum = sc.nextLong();
		if(Bank.isDuplicateAccount(accNum))
		{
			System.out.println("ACCOUNT NUMBER ALREADY EXISTS. TRY A DIFFERENT ONE.");
			return;
		}
		System.out.println("ENTER NAME");
		String name = sc.next();
		System.out.println("ENTER INTIAL AMOUNT");
		int balance = sc.nextInt();
		System.out.println("ENTER PIN");
		int pin = sc.nextInt();
		Bank.accountIndex++;
		Bank.accountList[Bank.accountIndex] = new BankAcc(accNum,name,balance,pin);	
	}

	
	@Override
	public void depositAmount() {
		System.out.println("ENTER ACCOUNT NUMBER:");
		long accNo = sc.nextLong();
		System.out.println("ENTER THE PIN");
		int pin = sc.nextInt();
		
		BankAcc acc = Bank.findAccount(accNo,pin);
		if(acc == null)
		{
			System.out.println("INVALID ACCOUNT NUMBER OR PIN!! TRY AGAIN");
			return;
		}
		System.out.print("Enter Amount to Deposit: ");
		int depAmount = sc.nextInt();
		int total = acc.getBalance()+depAmount;
		acc.setBalance(total);
	}
	

	@Override
	public void withdrawAmount() {
		System.out.println("ENTER ACCOUNT NUMBER:");
		long accNo = sc.nextLong();
		System.out.println("ENTER THE PIN");
		int pin = sc.nextInt();
		
		BankAcc acc = Bank.findAccount(accNo,pin);
		if(acc == null)
		{
			System.out.println("INVALID ACCOUNT NUMBER OR PIN!! TRY AGAIN");
			return;
		}
		System.out.print("Enter Amount to Withdraw: ");
		int withAmount = sc.nextInt();
		
		if(acc.getBalance()>=withAmount)
		{
		int total = acc.getBalance()-withAmount;
		acc.setBalance(total);
		}
		else
		{
			System.out.println("INSUFFICIENT AMOUNT !!");
			return;
		}
	}

	@Override
	public void checkBalance() 
	{
		
		System.out.println("ENTER ACCOUNT NUMBER:");
		long accNo = sc.nextLong();
		System.out.println("ENTER THE PIN");
		int pin = sc.nextInt();
		BankAcc acc = Bank.findAccount(accNo,pin);
		if(acc == null)
		{
			System.out.println("INVALID ACCOUNT NUMBER OR PIN!! TRY AGAIN");
			return;
		}
		
		int balance = acc.getBalance();
		System.out.println("Available Balance → " + balance);
		
	}

	@Override
	public void accountHoldersList() {
		System.out.println("\n--- ACCOUNT HOLDERS LIST ---");
        for (int i = 0; i <= Bank.accountIndex; i++) {
            System.out.println(Bank.accountList[i]);
        }
		
	}

}
