package com.nespresso.sofa.interview.hospital.code.entities;

public class HealthyPatient extends Patient
{

	public HealthyPatient ()
	{
		
	}
	
	HealthyPatient (final boolean hasTakenParacetamol)
	{
		this();
		this.hasTakenParacetamol = hasTakenParacetamol;
	}
	
	@Override
	public Patient antibiotic()
	{
		// TODO Auto-generated method stub
		if (hasTakenInsulin)
		{
			return new FeveredPatient();
		}
		
		return super.antibiotic();
	}

	@Override
	public Patient insulin()
	{
		// TODO Auto-generated method stub
		if (hasTakenAntibiotic)
		{
			return new FeveredPatient();
		}
		
		return super.insulin();
	}

	@Override
	public Character present()
	{
		// TODO Auto-generated method stub
		return 'H';
	}
	
	
	
}
