package com.nespresso.sofa.interview.hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nespresso.sofa.interview.hospital.code.Quarantine;

public class QuarantineTest
{
	@Test
    public void withoutTreatmentNorTime() throws Exception {
        Quarantine quarantine = new Quarantine("F,H,D,T");
        assertEquals("F:1 H:1 D:1 T:1 X:0", quarantine.report());
    }
	
	@Test
    public void withoutTreatment() throws Exception {
        Quarantine quarantine = new Quarantine("F,H,D,D,D,T");
        quarantine.wait40Days();
        // diabetics die without insulin
        assertEquals("F:1 H:1 D:0 T:1 X:3", quarantine.report());
    }

    @Test
    public void aspirin() throws Exception {
        Quarantine quarantine = new Quarantine("F,F,F,H,D,T");
        quarantine.aspirin();
        quarantine.wait40Days();
        // aspirin cure Fever
        assertEquals("F:0 H:4 D:0 T:1 X:1", quarantine.report());
    }

    @Test
    public void antibiotic() throws Exception {
        Quarantine quarantine = new Quarantine("F,H,D,D,D,H,T");
        quarantine.antibiotic();
        quarantine.wait40Days();
        // antibiotic cure Tuberculosis
        // but healthy people catch Fever if mixed with insulin.
        assertEquals("F:1 H:3 D:0 T:0 X:3", quarantine.report());
    }

    @Test
    public void insulin() throws Exception {
        Quarantine quarantine = new Quarantine("F,H,D,D,D,H,T");
        quarantine.insulin();
        quarantine.wait40Days();
        // insulin prevent diabetic subject from dying, does not cure Diabetes,
        assertEquals("F:1 H:2 D:3 T:1 X:0", quarantine.report());
    }

    @Test
    public void antibioticPlusInsulin() throws Exception {
        Quarantine quarantine = new Quarantine("F,H,D,D,D,H,T");
        quarantine.antibiotic();
        quarantine.insulin();
        quarantine.wait40Days();
        // if insulin is mixed with antibiotic, healthy people catch Fever
        assertEquals("F:3 H:1 D:3 T:0 X:0", quarantine.report());
    }

    @Test
    public void paracetamol() throws Exception {
        Quarantine quarantine = new Quarantine("F,F,H,D,D,D,H,T");
        quarantine.paracetamol();
        quarantine.wait40Days();
        // paracetamol heals fever
        assertEquals("F:0 H:4 D:0 T:1 X:3", quarantine.report());
    }

    @Test
    public void paracetamolAndAspirin() throws Exception {
        Quarantine quarantine = new Quarantine("F,H,D,D,D,H,T");
        quarantine.paracetamol();
        quarantine.aspirin();
        // mixing paracetamol & aspirin INSTANTLY kills subject !
        assertEquals("F:0 H:0 D:0 T:0 X:7", quarantine.report());
    }

}
