package enums;
import Interface.IDeceaseInstanceInitializer;
import Strategies.*;
import ClassesMain.Patient;

public enum EDeceases {
    COLD(new ColdStrategy(new Patient())),
    FLU(new FluStrategy(new Patient())),
    HEADACHE(new HeadAcheStrategy(new Patient())),
    STOMACH_ACHE(new StomachAcheStrategy(new Patient())),
    SORE_THROAT(new SoreThroatStrategy(new Patient())),
    VOMITING(new VomitingStrategy(new Patient())),
    BACTERIAL_INFECTION(new BacterialInfectionStrategy(new Patient())),
    BURN(new BurnStrategy(new Patient()));
     private final IDeceaseInstanceInitializer instanceInitializer;

    EDeceases(IDeceaseInstanceInitializer instanceInitializer) {
        this.instanceInitializer = instanceInitializer;
    }


    public IDeceaseInstanceInitializer getInstanceInitializer() {
            return instanceInitializer;
        }

}
