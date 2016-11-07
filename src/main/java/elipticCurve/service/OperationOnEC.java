package elipticCurve.service;

import elipticCurve.model.*;

import java.math.BigInteger;


/**
 * Created by Alexey on 09.02.2016
 */
public interface OperationOnEC {
    ECPoint calculateSumOfPoint(ECPoint p1, ECPoint p2);
    ECPoint calculateDoubling(ECPoint p);
    ECPoint calculateMultiply(ECPoint p, BigInteger mulParamN);
    ECPoint calculateDifference(ECPoint p1, ECPoint p2);
}
