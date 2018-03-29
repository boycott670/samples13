package com.nespresso.sofa.interview.hospital.code;

import java.util.Arrays;
import java.util.function.UnaryOperator;

import com.nespresso.sofa.interview.hospital.code.entities.Patient;
import com.nespresso.sofa.interview.hospital.code.parsers.DefaultPatientsHealthStatusesParser;
import com.nespresso.sofa.interview.hospital.code.parsers.PatientsHealthStatusesParser;
import com.nespresso.sofa.interview.hospital.code.presenters.DefaultPatientsHealthStatusesPresenter;
import com.nespresso.sofa.interview.hospital.code.presenters.PatientsHealthStatusesPresenter;

public class Quarantine extends Object
{
	private final PatientsHealthStatusesParser parser = new DefaultPatientsHealthStatusesParser();
	private final PatientsHealthStatusesPresenter presenter = new DefaultPatientsHealthStatusesPresenter();
	
	private Patient[] patients;
	
	public Quarantine (final String patientsHealthStatuses)
	{
		patients = new PatientFactory().get(parser.parse(patientsHealthStatuses));
	}
	
	private void updatePatients (final UnaryOperator<Patient> patientHealthStatusUpdater)
	{
		patients = Arrays.stream(patients)
			.map(patientHealthStatusUpdater)
			.toArray(Patient[]::new);
	}
	
	public void wait40Days ()
	{
		updatePatients(Patient::wait40Days);
	}
	
	public void aspirin ()
	{
		updatePatients(Patient::aspirin);
	}
	
	public void antibiotic ()
	{
		updatePatients(Patient::antibiotic);
	}
	
	public void insulin ()
	{
		updatePatients(Patient::insulin);
	}
	
	public void paracetamol ()
	{
		updatePatients(Patient::paracetamol);
	}
	
	public String report ()
	{
		return presenter.present(patients);
	}
}
