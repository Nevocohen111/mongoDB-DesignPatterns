package Strategies;
import Interface.IDeceaseInstanceInitializer;
import enums.EDeceases;
import ClassesMain.DeceaseDetails;
import ClassesMain.Patient;

public class HeadAcheStrategy implements IDeceaseInstanceInitializer {
    Patient patient;

    public HeadAcheStrategy(Patient patient) {
        this.patient = patient;
    }
    @Override
    public DeceaseDetails initialize(DeceaseDetails details, Patient patient) {
        details.addDecease(EDeceases.HEADACHE);
        System.out.println(patient.getName()+" has a headache");
        return details;
    }
}
