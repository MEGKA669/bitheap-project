package automation.drivers.strategies;
import automation.utils.constantes;

public class executantstrategieConducteur {

    public static strategieConducteur choixStrategie(String strategie) {
        switch (strategie) {
            case constantes.CHROME:
                return new Chrome();
            case constantes.PHANTOMJS:
                return new PhantomJs();
            case constantes.FIREFOX:
                return new Firefox();
            default:
                return null;
        }
    }
}
