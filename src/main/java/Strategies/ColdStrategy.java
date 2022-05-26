package Strategies;
import Interface.IDeceaseInstanceInitializer;
import enums.EDeceases;
import ClassesMain.DeceaseDetails;
import ClassesMain.Patient;

public class ColdStrategy implements IDeceaseInstanceInitializer {
    Patient patient;

    public ColdStrategy(Patient patient) {
        this.patient = patient;
    }
    @Override
    public DeceaseDetails initialize(DeceaseDetails details, Patient patient) {
        details.addDecease(EDeceases.COLD);
        System.out.println(patient.getName()+" has a cold");
        return details;
    }
}
