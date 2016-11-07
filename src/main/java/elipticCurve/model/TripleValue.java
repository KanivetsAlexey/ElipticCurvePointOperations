package elipticCurve.model;

import java.math.BigInteger;

/**
 * Created by Alexey on 09.02.2016
 */
public class TripleValue {
    public BigInteger x;
    public BigInteger y;
    public BigInteger r;

    public TripleValue() {
        x = BigInteger.ZERO;
        y = BigInteger.ZERO;
        r = BigInteger.ZERO;
    }

    public TripleValue(BigInteger x, BigInteger y, BigInteger r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
