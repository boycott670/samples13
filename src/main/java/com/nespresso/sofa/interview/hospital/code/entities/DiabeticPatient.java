package com.nespresso.sofa.interview.hospital.code.entities;

public class DiabeticPatient extends Patient
{

	@Override
	public Patient wait40Days()
	{
		// TODO Auto-generated method stub
		if (!hasTakenInsulin)
		{
			return new DeadPatient();
		}
		
		return super.wait40Days();
	}

	@Override
	public Character present()
	{
		// TODO Auto-generated method stub
		return 'D';
	}
}
