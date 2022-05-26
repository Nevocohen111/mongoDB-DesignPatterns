package Strategies;
import Interface.IDeceaseInstanceInitializer;
import enums.EDeceases;
import ClassesMain.DeceaseDetails;
import ClassesMain.Patient;

public class FluStrategy implements IDeceaseInstanceInitializer {
    Patient patient;

    public FluStrategy(Patient patient) {
        this.patient = patient;
    }
    @Override
    public DeceaseDetails initialize(DeceaseDetails details, Patient patient) {
        details.addDecease(EDeceases.FLU);
        System.out.println(patient.getName() + " has a flu");
        return details;
    }
}
