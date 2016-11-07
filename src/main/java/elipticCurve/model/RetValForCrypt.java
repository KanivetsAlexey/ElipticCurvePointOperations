package elipticCurve.model;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Alexey on 11.04.2016
 */
public class RetValForCrypt {
    public ECPoint Db;
    public ECPoint R;
    public BigInteger secretKey;
    public ArrayList<ECPoint> encRes;

    public RetValForCrypt(ECPoint Db, ECPoint R, BigInteger secretKey,ArrayList encRes) {
        this.Db = Db;
        this.R = R;
        this.secretKey = secretKey;
        this.encRes = encRes;
    }
}
