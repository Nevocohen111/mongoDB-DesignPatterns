package ClassesMain;
import Interface.IDeceaseInstanceInitializer;
import enums.EDeceases;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private final String name;
    private final List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        int MAX_PATIENTS = 10;
        this.patients = new ArrayList<>(MAX_PATIENTS);
    }

    public void addPatient(Patient patient) {
        if(!patients.contains(patient)) {
            patients.add(patient);
        }
    }
    public void printPatients() {
        for(Patient patient : patients) {
            System.out.println(patient);
        }
    }
    public IDeceaseInstanceInitializer getStrategy(EDeceases decease) {
        return decease.getInstanceInitializer();
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public DeceaseDetails getDecease(IDeceaseInstanceInitializer strategy,Patient patient) {
        DeceaseDetails details = new DeceaseDetails();
        patient = new Patient(patient.getName(),patient.getAge(), patient.getIsHealthy(), patient.getReservationId(),patient.getDoctorName(),patient.getDoctorSpecialization(),patient.getDeceaseName(),patient.getTimeOfReservation());
        details = strategy.initialize(details, patient);
        return details;
    }


    public String getName() {
        return name;
    }
}
