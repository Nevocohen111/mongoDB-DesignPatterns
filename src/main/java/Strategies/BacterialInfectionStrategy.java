package Strategies;
import Interface.IDeceaseInstanceInitializer;
import enums.EDeceases;
import ClassesMain.DeceaseDetails;
import ClassesMain.Patient;

public class BacterialInfectionStrategy implements IDeceaseInstanceInitializer {
    Patient patient;

    public BacterialInfectionStrategy(Patient patient) {
        this.patient = patient;
    }
    @Override
    public DeceaseDetails initialize(DeceaseDetails details,Patient patient) {
        details.addDecease(EDeceases.BACTERIAL_INFECTION);
        System.out.println(patient.getName()+" has a bacterial infection");
        return details;
    }

}
