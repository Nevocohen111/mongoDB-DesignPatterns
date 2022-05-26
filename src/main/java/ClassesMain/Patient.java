package ClassesMain;
import java.util.Date;

public class Patient extends Person{
    private String ReservationId;
    private String DoctorName;
    private String DoctorSpecialization;
    private String deceaseName;

    private Date timeOfReservation;

    public Patient(String name, int age, boolean isHealthy, String ReservationId, String DoctorName, String DoctorSpecialization, String deceaseName, Date timeOfReservation) {
        super(name, age, isHealthy);
        this.timeOfReservation = timeOfReservation;
        this.ReservationId = ReservationId;
        this.DoctorName = DoctorName;
        this.DoctorSpecialization = DoctorSpecialization;
        this.deceaseName = deceaseName;
    }
    public Patient(){}

    public Date getTimeOfReservation() {
        return timeOfReservation;
    }
    public String getReservationId() {
        return ReservationId;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public String getDoctorSpecialization() {
        return DoctorSpecialization;
    }

    public String getDeceaseName() {
        return deceaseName;
    }

    public String toString() {
        return "Reservation id: " + ReservationId + ", DoctorName: " + DoctorName + ", DoctorSpecialization: " + DoctorSpecialization + ", deceaseName: " + deceaseName+ ", timeOfReservation: " + timeOfReservation;
    }


    public static class PatientBuilder {
        private String withName;
        private boolean withIsHealthy;
        private int withAge;
        private String withReservationId;
        private String withDoctorName;
        private String withDoctorSpecialization;
        private String withDeceaseName;
        private Date withTimeOfReservation;



        public PatientBuilder withName(String name) {
            this.withName = name;
            return this;
        }

        public PatientBuilder withTimeOfReservation(Date timeOfReservation) {
            this.withTimeOfReservation = timeOfReservation;
            return this;
        }

        public PatientBuilder withAge(int age) {
            this.withAge = age;
            return this;
        }

        public PatientBuilder withIsHealthy(boolean isHealthy) {
            this.withIsHealthy = isHealthy;
            return this;
        }


        public PatientBuilder withReservationId(String ReservationId) {
            this.withReservationId = ReservationId;
            return this;
        }

        public PatientBuilder withDoctorName(String DoctorName) {
            this.withDoctorName = DoctorName;
            return this;
        }

        public PatientBuilder withDoctorSpecialization(String DoctorSpecialization) {
            this.withDoctorSpecialization = DoctorSpecialization;
            return this;
        }


        public PatientBuilder withDeceaseName(String deceaseName) {
            this.withDeceaseName = deceaseName;
            return this;
        }


        public Patient build() {
            return new Patient(withName, withAge, withIsHealthy, withReservationId, withDoctorName, withDoctorSpecialization, withDeceaseName,withTimeOfReservation);
        }
    }
}
