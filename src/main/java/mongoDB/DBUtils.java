package mongoDB;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import ClassesMain.Patient;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUtils {
    private static volatile DBUtils instance = null;

    public static DBUtils getInstance() {
        if (instance == null) {
            synchronized (DBUtils.class) {
                if (instance == null) {
                    instance = new DBUtils();
                }
            }
        }
        return instance;
    }


    public MongoClient getMongoClient() {
        Logger logger = Logger.getLogger("org.mongodb.driver");
        logger.setLevel(Level.SEVERE);
        return MongoClients.create("mongodb://localhost:27017");
    }

    public MongoDatabase getDatabase() {
        return getMongoClient().getDatabase("hospital");
    }

    public MongoCollection<Document> getCollection() {
        return getDatabase().getCollection("patients");
    }

    public void addPatient(Patient patient) {
        getCollection().insertOne(new Document("name", patient.getName())
                .append("age", patient.getAge())
                .append("isHealthy", patient.getIsHealthy())
                .append("reservationId", patient.getReservationId())
                .append("doctorName", patient.getDoctorName())
                .append("doctorSpecialization", patient.getDoctorSpecialization())
                .append("deceaseName", patient.getDeceaseName())
                .append("timeOfReservation", patient.getTimeOfReservation()));
    }

    public void printAllPatients() {
        getCollection().find().forEach(System.out::println);
    }

    public void deleteAllPatients() {
        getCollection().deleteMany(new Document());
    }

    public void deletePatient(String patient) {
        getCollection().deleteOne(new Document("name", patient));
    }

    public void updatePatientHealthState(String name) {
        if (getCollection().find(Filters.eq("name", name)).first().getBoolean("isHealthy")) {
            getCollection().updateOne(Filters.eq("name", name), new Document("$set", new Document("isHealthy", false)));
        } else {
            getCollection().updateOne(Filters.eq("name", name), new Document("$set", new Document("isHealthy", true)));
        }
    }

    public String getPatientHealthState(String name) {
        if (getCollection().find(Filters.eq("name", name)).first().getBoolean("isHealthy")) {
            return "healthy";
        } else {
            return "sick";
        }
    }

    public String getTheOppositePatientHealthState(String name) {
        if (getCollection().find(Filters.eq("name", name)).first().getBoolean("isHealthy")) {
            return "sick";
        } else {
            return "healthy";
        }
    }

    public void updatePatientHourOfVisit(String patient, Date date) {
        getCollection().updateOne(Filters.eq("name", patient), new Document("$set", new Document().append("timeOfReservation", date)));
    }

    public void findPatientByName(String name) {
        getCollection().find(Filters.eq("name", name)).forEach(System.out::println);
    }

    public Date getPatientHourOfVisit(String name) {
        try {
            return getCollection().find(Filters.eq("name", name)).first().getDate("timeOfReservation");
        } catch (NullPointerException e) {
            return null;
        }
    }

}
