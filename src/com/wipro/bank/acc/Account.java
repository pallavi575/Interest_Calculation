package com.wipro.bank.acc;

abstract class Account 
{
	int tenure;
	float principal;
	float rateOfInterest;
	public void setInterest(int age, String gender)
	{
		if(gender.equals("Male"))
		{
			if(age<60)
				rateOfInterest=9.8f;
			else
				rateOfInterest=10.8f;
		}
		if(gender.equals("Female"))
		{
			if(age<58)
				rateOfInterest=10.2f;
			else
				rateOfInterest=10.8f;
		}
		System.out.println("Rate of Interest: "+rateOfInterest);
	}
	public float calculateMaturityAmount(float totalPrincipleDeposited,float maturityInterest)
	{
		return totalPrincipleDeposited+maturityInterest;
	}
	public abstract float calculateInterest();
	public abstract float calculateAmountDeposited();

}
