package com.nespresso.sofa.interview.hospital.code.entities;

public class TuberculosisedPatient extends Patient
{

	@Override
	public Patient antibiotic()
	{
		// TODO Auto-generated method stub
		return new HealthyPatient();
	}

	@Override
	public Character present()
	{
		// TODO Auto-generated method stub
		return 'T';
	}
	
	
	
}
