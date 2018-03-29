package com.nespresso.sofa.interview.hospital.code.entities;

public abstract class Patient extends Object
{
	boolean hasTakenAspirin = false;
	boolean hasTakenAntibiotic = false;
	boolean hasTakenInsulin = false;
	boolean hasTakenParacetamol = false;
	
	public abstract Character present ();
	
	public Patient wait40Days ()
	{
		return this;
	}
	
	public Patient aspirin ()
	{
		if (hasTakenParacetamol)
		{
			return new DeadPatient();
		}
		
		hasTakenAspirin = true;
		
		return this;
	}
	
	public Patient antibiotic ()
	{
		hasTakenAntibiotic = true;
		
		return this;
	}
	
	public Patient insulin ()
	{
		hasTakenInsulin = true;
		
		return this;
	}
	
	public Patient paracetamol ()
	{
		if (hasTakenAspirin)
		{
			return new DeadPatient();
		}
		
		hasTakenParacetamol = true;
		
		return this;
	}
}
