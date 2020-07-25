package com.wipro.bank.service;
import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.*;
public class BankService 
{
	public boolean validateData(float principal, int tenure,int age, String gender)
	{
		try
		{
			if(principal<500)
				throw new BankValidationException("Principal should be minimum 500");
			if(!(tenure==5 || tenure==10))
				throw new BankValidationException("5 or 10 only");
			if(!(gender.equalsIgnoreCase("Male")||(gender.equalsIgnoreCase("Female"))))
				throw new BankValidationException("Only male or female");
			if(age<1 || age>100)
				throw new BankValidationException("Age should be in between 1 to 100");		
		}
		catch(BankValidationException bve)
		{
			return false;
		}
		return true;
	}
	public void calculate(float principal,int tenure, int age, String gender)
	{
		boolean validateFlag=validateData(principal,tenure,age,gender);
			System.out.println(validateFlag);
			//System.out.println(principal);
			//System.out.println(tenure);
			//System.out.println(age);
			//System.out.println(gender);
			if(validateFlag)
			{
				RDAccount rda=new RDAccount(tenure,principal);
				rda.setInterest(age, gender);
				float maturityInterest=rda.calculateInterest();
				float totalPrincipalDeposited=rda.calculateAmountDeposited();
				System.out.println("Maturity Interest: "+maturityInterest);
				System.out.println("Total Principal Deposited: "+totalPrincipalDeposited);
				System.out.println("Maturity Amount: "+rda.calculateMaturityAmount(totalPrincipalDeposited,maturityInterest));
			}
	}
}
