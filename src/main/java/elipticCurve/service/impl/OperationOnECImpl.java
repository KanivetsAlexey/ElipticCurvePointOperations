package elipticCurve.service.impl;

import elipticCurve.model.ECPoint;
import elipticCurve.service.CalculateHelper;
import elipticCurve.service.OperationOnEC;

import java.math.BigInteger;

/**
 * Created by Alexey on 03.04.2016
 */
public class OperationOnECImpl implements OperationOnEC {
    private CalculateHelper calculateHelper;

    public OperationOnECImpl() {
        calculateHelper = new CalculateHelper();
    }

    @Override
    public ECPoint calculateDoubling(ECPoint p) {
        ECPoint p2 = new ECPoint();
        p2.a = p.a;
        p2.b = p.b;
        p2.curveParam = p.curveParam;
        BigInteger lyambda = calculateHelper.lyambdaCalculation(p);
        if (lyambda.compareTo(BigInteger.ZERO) < 0){
            lyambda = lyambda.add(p.curveParam);
        }
        p2.x = calculateHelper.newXCalculation(p, p, lyambda);
        p2.y = calculateHelper.newYCalculation(p, p2, lyambda);
        return p2;
    }

    @Override
    public ECPoint calculateDifference(ECPoint p1, ECPoint p2) {
        ECPoint p3 = new ECPoint();
        p3.a = p1.a;
        p3.b = p1.b;
        p3.curveParam = p1.curveParam;
        p2.y = p2.curveParam.subtract(p2.y);
        BigInteger lyambda = calculateHelper.lyambdaCalculationDifPoints(p1, p2);
        if (lyambda.compareTo(BigInteger.ZERO) < 0){
            lyambda = lyambda.add(p1.curveParam);
        }
        p3.x = calculateHelper.newXCalculation(p1, p2, lyambda);
        p3.y = calculateHelper.newYCalculation(p1, p3, lyambda);
        return p3;
    }

    @Override
    public ECPoint calculateMultiply(ECPoint p, BigInteger mulParamN) {
        ECPoint temp = p;
        mulParamN = mulParamN.subtract(BigInteger.ONE);
        while (!mulParamN.equals(BigInteger.ZERO)){
            if (!(mulParamN.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO))){
                if (temp.x.equals(p.x) || temp.y.equals(p.y))//TODO
                    temp = calculateDoubling(temp);
                else
                    temp = calculateSumOfPoint(temp, p);
                mulParamN = mulParamN.subtract(BigInteger.ONE);
            }
            mulParamN = mulParamN.divide(BigInteger.valueOf(2));
            p = calculateDoubling(p);
        }
        return temp;
    }

    @Override
    public ECPoint calculateSumOfPoint(ECPoint p1, ECPoint p2) {
        ECPoint p3 = new ECPoint();
        p3.a = p1.a;
        p3.b = p1.b;
        p3.curveParam = p1.curveParam;
        BigInteger lyambda = calculateHelper.lyambdaCalculationDifPoints(p1, p2);
        if (lyambda.compareTo(BigInteger.ZERO) < 0){
            lyambda = lyambda.add(p1.curveParam);
        }
        p3.x = calculateHelper.newXCalculation(p1, p2, lyambda);
        p3.y = calculateHelper.newYCalculation(p1, p3, lyambda);
        return p3;
    }
}
