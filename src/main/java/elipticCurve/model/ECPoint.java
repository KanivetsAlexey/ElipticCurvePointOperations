package elipticCurve.model;

import java.math.BigInteger;

/**
 * Created by Alexey on 08.02.2016
 */
public class ECPoint {
    public BigInteger x;
    public BigInteger y;
    public BigInteger a;
    public BigInteger b;
    public BigInteger curveParam;

    public ECPoint(ECPoint p)
    {
        x = p.x;
        y = p.y;
        a = p.a;
        b = p.b;
        curveParam = p.curveParam;
    }

    public ECPoint()
    {
        x = BigInteger.ZERO;
        y = BigInteger.ZERO;
        a = BigInteger.ZERO;
        b = BigInteger.ZERO;
        curveParam = BigInteger.ZERO;
    }
}
