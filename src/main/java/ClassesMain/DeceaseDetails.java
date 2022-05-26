package ClassesMain;
import enums.EDeceases;
import java.util.ArrayList;
import java.util.List;

public class DeceaseDetails {
    private final List<EDeceases> deceases;
    private static int medicineQuantity = 100;

    public DeceaseDetails() {
        deceases = new ArrayList<>();
    }



    public void addDecease(EDeceases decease) {
        if(findDecease(decease) == -1 && medicineQuantity > 0) {
            deceases.add(decease);
            medicineQuantity--;
        }
    }

    public int findDecease(EDeceases decease) {
        return deceases.indexOf(decease);
    }

    @Override
    public String toString() {
       return "DeceaseDetails{" +
                "deceases=" + deceases +
                ", medicineQuantity=" + medicineQuantity +
                '}';
    }
}
