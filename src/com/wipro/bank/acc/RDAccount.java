package com.wipro.bank.acc;

public class RDAccount extends Account
{
	public RDAccount(int tenure, float principal)
	{
		this.tenure=tenure;
		this.principal=principal;
	}
	public float calculateInterest() 
	{
		float r=rateOfInterest/100;
		int n=4;
		//float t=(tenure*12)/12f
		float p=0.0f;
		int nt=tenure*12;
		for(int i=0;i<nt;i++)
		{
			p+=principal*(float)(Math.pow(1+(r/n),n*((nt-1)/12.0))-1);
		}
		
		return p;
	}

	public float calculateAmountDeposited() 
	{
		return principal*tenure*12;
	}
	
}
