package Strategies;
import Interface.IDeceaseInstanceInitializer;
import enums.EDeceases;
import ClassesMain.DeceaseDetails;
import ClassesMain.Patient;

public class SoreThroatStrategy implements IDeceaseInstanceInitializer {

    Patient patient;

    public SoreThroatStrategy(Patient patient) {
        this.patient = patient;
    }
    @Override
    public DeceaseDetails initialize(DeceaseDetails details, Patient patient) {
        details.addDecease(EDeceases.SORE_THROAT);
        System.out.println(patient.getName()+" has a sore throat");
        return details;
    }
}
