package Strategies;
import Interface.IDeceaseInstanceInitializer;
import enums.EDeceases;
import ClassesMain.DeceaseDetails;
import ClassesMain.Patient;

public class StomachAcheStrategy implements IDeceaseInstanceInitializer {

    Patient patient;

    public StomachAcheStrategy(Patient patient) {
        this.patient = patient;
    }
    @Override
    public DeceaseDetails initialize(DeceaseDetails details, Patient patient) {
        details.addDecease(EDeceases.STOMACH_ACHE);
        System.out.println(patient.getName()+" has a stomach ache");
        return details;
    }
}
