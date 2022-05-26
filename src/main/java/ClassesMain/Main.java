package ClassesMain;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Patient Josh = new Patient.PatientBuilder().withName("Josh").withAge(15).withIsHealthy(true).withReservationId("203").withDoctorName("Dr.Nevo").withDoctorSpecialization("Bacteriology").withDeceaseName("Eye Infection").withTimeOfReservation(new Date( System.currentTimeMillis()+3600000)).build();
        Patient Joseph = new Patient.PatientBuilder().withName("Joseph").withAge(30).withIsHealthy(false).withReservationId("201").withDoctorName("Dr.Vergara").withDoctorSpecialization("Throat viruses").withDeceaseName("Flu").withTimeOfReservation(new Date(System.currentTimeMillis()+7200000)).build();
        Patient Jimmy = new Patient.PatientBuilder().withName("Jimmy").withAge(10).withIsHealthy(true).withReservationId("192").withDoctorName("Dr.Smith").withDoctorSpecialization("Pediatrics").withDeceaseName("vomiting").withTimeOfReservation(new Date(System.currentTimeMillis()+5200000)).build();
        Patient John = new Patient.PatientBuilder().withName("John").withAge(20).withIsHealthy(false).withReservationId("123").withDoctorName("Dr.David").withDoctorSpecialization("Stomach infections").withDeceaseName("Burns").withTimeOfReservation(new Date(System.currentTimeMillis()+20000000)).build();
        Patient Jane = new Patient.PatientBuilder().withName("Jane").withAge(18).withIsHealthy(false).withReservationId("145").withDoctorName("Dr.Hertzel").withDoctorSpecialization("Viral viruses").withDeceaseName("Throat infection").withTimeOfReservation(new Date(System.currentTimeMillis()+100000)).build();
        Patient Jason = new Patient.PatientBuilder().withName("Jason").withAge(25).withIsHealthy(false).withReservationId("167").withDoctorName("Dr.Beygale").withDoctorSpecialization("Tension solutions").withDeceaseName("Headache").withTimeOfReservation(new Date(System.currentTimeMillis()+320000)).build();
        //adding patients to the pharmacy
        Hospital Leumit = new Hospital("Leumit");
        Leumit.addPatient(Joseph);
        Leumit.addPatient(Josh);
        Leumit.addPatient(John);
        Leumit.addPatient(Jimmy);
        Leumit.addPatient(Jane);
        Leumit.addPatient(Jason);
        Print.printDeceaseDetails(Leumit);


        //initializing the strategies.
  /*    IDeceaseInstanceInitializer eyeInfection = Leumit.getStrategy(EDeceases.BACTERIAL_INFECTION);
        IDeceaseInstanceInitializer flu = Leumit.getStrategy(EDeceases.FLU);
        IDeceaseInstanceInitializer burn = Leumit.getStrategy(EDeceases.BURN);
        IDeceaseInstanceInitializer headache = Leumit.getStrategy(EDeceases.HEADACHE);
        IDeceaseInstanceInitializer throatVirus = Leumit.getStrategy(EDeceases.BACTERIAL_INFECTION);
        IDeceaseInstanceInitializer vomiting = Leumit.getStrategy(EDeceases.VOMITING);
        Leumit.getDecease(eyeInfection,Josh);
        Leumit.getDecease(flu,Joseph);
        Leumit.getDecease(burn,John);
        Leumit.getDecease(headache,Jason);
        Leumit.getDecease(throatVirus,Jane);
        Leumit.getDecease(vomiting,Jimmy);*/









    }
}