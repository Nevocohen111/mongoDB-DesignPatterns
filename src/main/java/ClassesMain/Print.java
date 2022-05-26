package ClassesMain;

public class Print {
    public static void printDeceaseDetails(Hospital hospital) {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s"," full Decease report");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println();

        for (Patient patient : hospital.getPatients()) {
            System.out.println("Name: " + patient.getName() +
                    ",Decease: " + patient.getDeceaseName()+
                    ",Doctor: "+patient.getDoctorName()+
                    ",Specialization: "+patient.getDoctorSpecialization()+
                    ",Reservation ID: "+patient.getReservationId()+
                    ",Time of reservation: "+patient.getTimeOfReservation()+"\n");
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("All of the patients details have successfully loaded into the system");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }


}
