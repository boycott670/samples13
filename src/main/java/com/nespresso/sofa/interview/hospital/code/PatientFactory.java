package com.nespresso.sofa.interview.hospital.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import com.nespresso.sofa.interview.hospital.code.entities.DiabeticPatient;
import com.nespresso.sofa.interview.hospital.code.entities.FeveredPatient;
import com.nespresso.sofa.interview.hospital.code.entities.HealthyPatient;
import com.nespresso.sofa.interview.hospital.code.entities.Patient;
import com.nespresso.sofa.interview.hospital.code.entities.TuberculosisedPatient;

class PatientFactory extends Object
{
	private Patient get (final Character healthStatus)
	{
		final Map<Character, Supplier<? extends Patient>> codeForPatientTypeMapping = new HashMap<>();
		
		codeForPatientTypeMapping.put('H', HealthyPatient::new);
		codeForPatientTypeMapping.put('F', FeveredPatient::new);
		codeForPatientTypeMapping.put('D', DiabeticPatient::new);
		codeForPatientTypeMapping.put('T', TuberculosisedPatient::new);
		
		return Optional.ofNullable(codeForPatientTypeMapping.get(healthStatus))
			.orElseThrow(() -> new IllegalArgumentException("Invalid health status code"))
			.get();
	}
	
	Patient[] get (final Character[] healthStatuses)
	{
		return Arrays.stream(healthStatuses)
			.map(this::get)
			.toArray(Patient[]::new);
	}
}
