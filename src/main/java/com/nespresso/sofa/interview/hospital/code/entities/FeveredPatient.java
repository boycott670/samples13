package com.nespresso.sofa.interview.hospital.code.entities;

public class FeveredPatient extends Patient
{

	@Override
	public Patient aspirin()
	{
		// TODO Auto-generated method stub
		if (!hasTakenParacetamol)
		{
			return new HealthyPatient();
		}
		
		return super.aspirin();
	}

	@Override
	public Patient paracetamol()
	{
		// TODO Auto-generated method stub
		if (!hasTakenAspirin)
		{
			return new HealthyPatient(true);
		}
		
		return super.paracetamol();
	}

	@Override
	public Character present()
	{
		// TODO Auto-generated method stub
		return 'F';
	}
	
	
	
}
