package Strategies;
import Interface.IDeceaseInstanceInitializer;
import enums.EDeceases;
import ClassesMain.DeceaseDetails;
import ClassesMain.Patient;

public class BurnStrategy implements IDeceaseInstanceInitializer {

    Patient patient;

    public BurnStrategy(Patient patient) {
        this.patient = patient;
    }
    @Override
    public DeceaseDetails initialize(DeceaseDetails details,Patient patient) {
        details.addDecease(EDeceases.BURN);
        System.out.println(patient.getName()+" has a burn");
        return details;
    }

}
