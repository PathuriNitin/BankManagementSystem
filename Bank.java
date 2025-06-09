package com.bank;

import java.util.Scanner;

public class Bank 
{
	static BankAcc accountList[] = new BankAcc[100];
	static Scanner sc = new Scanner(System.in);
	static int accountIndex = -1;
	
	public static void main(String args[])
	{
		BankOperationsImplement obj = new BankOperationsImplement();
		int option;
		do
		{
			menu();
			option = sc.nextInt();
			switch(option)
			{
			case 1: obj.createAccount();
			break;
			
			case 2: obj.depositAmount();
			break;
			
			case 3: obj.withdrawAmount();
	        break;
	        
			case 4: obj.checkBalance();
	        break;
	        
			case 5: obj.accountHoldersList();
	        break;
	        
			case 6:
				System.out.println("PROGRAM ENDS");
				System.exit(0);
				
			default:
				 System.out.println("INVALID OPTION! TRY AGAIN");
			        
			}
			
		}while(true);
		
	}
	
	public static void menu()
	{
		System.out.println("\n----------WELCOME TO BANK MANAGEMENT SYSTEM----------------");
		System.out.println("1.CREATE ACCOUNT");
		System.out.println("2.DEPOSIT AMOUNNT");
		System.out.println("3.WITHDRAW AMOUNT");
		System.out.println("4.CHECK BALANCE");
		System.out.println("5.ACCOUNT HOLDERS LIST");
		System.out.println("6.EXIT");
	}
	
	public static boolean isDuplicateAccount(long accNo)
	{
		for(int i=0;i<=accountIndex;i++)
		{
			if(accountList[i]!= null && accountList[i].getAccountNumber()== accNo)
			{
				return true;
			}	
		}
		return false;
	}
	
	public static BankAcc findAccount(long accNo,int pin)
	{
		for(int i=0;i<=accountIndex;i++)
		{
			if(accountList[i].getAccountNumber()== accNo && accountList[i].getPin()==pin)
			{
				return accountList[i];
			}
		}
		return null;
	}
	
	
	
}
