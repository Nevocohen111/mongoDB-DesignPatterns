package ClassesMain;

import jdk.swing.interop.SwingInterOpUtils;

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
        System.out.println("Doctor's observations:");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Runnable r = () -> {
            try{
                Thread.sleep(2500);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Patients data successfully printed");
            }catch(InterruptedException e){
                System.out.println("Thread interrupted");
            }
            System.out.println("Saving the data to the Data base,Do not exit....");
            try {
                Thread.sleep(2500);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                hospital.getPatients().forEach(System.out::println);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Thank you for using our service.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        Thread t = new Thread(r);
        t.start();

    }


}
