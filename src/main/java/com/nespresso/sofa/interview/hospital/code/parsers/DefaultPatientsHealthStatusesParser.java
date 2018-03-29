package com.nespresso.sofa.interview.hospital.code.parsers;

import java.util.Arrays;

public class DefaultPatientsHealthStatusesParser implements PatientsHealthStatusesParser
{

	@Override
	public Character[] parse(final String patientsHealthStatuses)
	{
		// TODO Auto-generated method stub
		return Arrays.stream(patientsHealthStatuses.split(","))
			.map(patientHealthStatus -> patientHealthStatus.charAt(0))
			.toArray(Character[]::new);
	}
	
}
