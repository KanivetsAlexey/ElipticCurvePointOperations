package elipticCurve;

/**
 * Created by Alexey on 09.12.2015
 */
public abstract class SymmetricAlgorithm {

    MainController arg;

    public abstract void multiplication(int indexOfTab);

    public SymmetricAlgorithm(MainController arg) {

        this.arg = arg;

    }
}
