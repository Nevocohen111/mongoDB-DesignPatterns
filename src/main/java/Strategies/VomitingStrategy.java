package Strategies;
import Interface.IDeceaseInstanceInitializer;
import enums.EDeceases;
import ClassesMain.DeceaseDetails;
import ClassesMain.Patient;

public class VomitingStrategy implements IDeceaseInstanceInitializer {
    Patient patient;

    public VomitingStrategy(Patient patient) {
        this.patient = patient;
    }
    @Override
    public DeceaseDetails initialize(DeceaseDetails details, Patient patient) {
        details.addDecease(EDeceases.VOMITING);
        System.out.println(patient.getName()+" has a vomiting");
        return details;
    }
}
