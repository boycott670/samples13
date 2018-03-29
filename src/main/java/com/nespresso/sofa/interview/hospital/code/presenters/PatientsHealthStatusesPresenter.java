package com.nespresso.sofa.interview.hospital.code.presenters;

import com.nespresso.sofa.interview.hospital.code.entities.Patient;

public interface PatientsHealthStatusesPresenter
{
	String present (final Patient[] patients);
}
