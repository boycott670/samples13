package com.nespresso.sofa.interview.hospital.code.presenters;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.nespresso.sofa.interview.hospital.code.entities.Patient;

public class DefaultPatientsHealthStatusesPresenter implements PatientsHealthStatusesPresenter
{

	@Override
	public String present(Patient[] patients)
	{
		// TODO Auto-generated method stub
		final Map<? super Character, Long> countOfPatientsGroupedByHealthStatus = Arrays.stream(patients)
			.collect(Collectors.groupingBy(Patient::present, Collectors.counting()));
		
		return Arrays.stream(new Character[] { 'F', 'H', 'D', 'T', 'X' })
			.map(patientHealthStatus -> String.format("%c:%d", patientHealthStatus, Optional.ofNullable(countOfPatientsGroupedByHealthStatus.get(patientHealthStatus)).orElse(0L)))
			.collect(Collectors.joining(" "));
	}
	
}
