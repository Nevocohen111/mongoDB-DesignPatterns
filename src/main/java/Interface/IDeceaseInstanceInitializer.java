package Interface;
import ClassesMain.DeceaseDetails;
import ClassesMain.Patient;

public interface IDeceaseInstanceInitializer {
   DeceaseDetails initialize(DeceaseDetails details, Patient patient);
}
