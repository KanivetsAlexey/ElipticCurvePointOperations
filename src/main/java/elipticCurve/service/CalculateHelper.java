package elipticCurve.service;

import elipticCurve.model.ECPoint;
import elipticCurve.model.TripleValue;

import java.math.BigInteger;

/**
 * Created by Alexey on 09.02.2016
 */
public class CalculateHelper {

    //расчет координаты х для результирующей точки
    public BigInteger newXCalculation(ECPoint p1, ECPoint p2, BigInteger lyambda){
        BigInteger newX = lyambda.multiply(lyambda).subtract(p1.x).subtract(p2.x).remainder(p1.curveParam);
        //BigInteger newX = (int)(lyambda * lyambda - p1.x - p2.x) % p1.curveParam;
      //  System.out.println("newX " + newX);
        if (newX.compareTo(BigInteger.ZERO) < 0){
            newX = newX.add(p1.curveParam);
        }
     //   System.out.println("newX " + newX);
        return newX;
    }

    //расчет координаты у для результирующей точки
    public BigInteger newYCalculation(ECPoint p1, ECPoint p3, BigInteger lyambda){
        BigInteger newY = p1.x.subtract(p3.x).multiply(lyambda).subtract(p1.y).remainder(p1.curveParam);
        //BigInteger newY = (int)(lyambda * (p1.x - p3.x ) - p1.y) % p1.curveParam;
       // System.out.println("newY " + newY);
        if (newY.compareTo(BigInteger.ZERO) < 0){
            newY = newY.add(p1.curveParam);
        }
       // System.out.println("newY " + newY);
        return newY;
    }

    //расширеный метод евклида для получения обратного елемента
    public BigInteger extendedEuclid(ECPoint p, BigInteger k2){
        TripleValue first = new TripleValue(BigInteger.ONE, BigInteger.ZERO, p.curveParam);
        TripleValue second = new TripleValue(BigInteger.ZERO, BigInteger.ONE, k2);
        TripleValue third = new TripleValue(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE);
        BigInteger x, r, q, d;
        BigInteger y = BigInteger.ZERO;
        while(!third.r.equals(BigInteger.ZERO)){
            q = first.r.divide(second.r);
            third.r = first.r.subtract(q.multiply(second.r));
            third.x = first.x.subtract(q.multiply(second.x));
            third.y = first.y.subtract(q.multiply(second.y));
            replaceVariable(first, second, third);
            d = first.r;
            x = first.x;
            y = first.y;
        }
       // System.out.println("********** y " + y);
        return y;
    }

    //расширеный метод евклида для получения обратного елемента
    public BigInteger extendedEuclidForCrypt(BigInteger p, BigInteger k2){
        TripleValue first = new TripleValue(BigInteger.ONE, BigInteger.ZERO, p);
        TripleValue second = new TripleValue(BigInteger.ZERO, BigInteger.ONE, k2);
        TripleValue third = new TripleValue(BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE);
        BigInteger x, r, q, d;
        BigInteger y = BigInteger.ZERO;
        while(!third.r.equals(BigInteger.ZERO)){
            q = first.r.divide(second.r);
            third.r = first.r.subtract(q.multiply(second.r));
            third.x = first.x.subtract(q.multiply(second.x));
            third.y = first.y.subtract(q.multiply(second.y));
            replaceVariable(first, second, third);
            d = first.r;
            x = first.x;
            y = first.y;
        }
        // System.out.println("********** y " + y);
        return y;
    }

    //перестановка значений для расширенного лагоритма евклида
    private void replaceVariable(TripleValue first, TripleValue second, TripleValue third){
        first.r = second.r;
        second.r = third.r;
        first.x = second.x;
        second.x = third.x;
        first.y = second.y;
        second.y = third.y;
    }

    //лямбда для 1й точки
    public BigInteger lyambdaCalculation(ECPoint p){
        BigInteger lyambda;
        BigInteger k1;
        BigInteger k2;
        k1 = BigInteger.valueOf(3).multiply(p.x).multiply(p.x).add(p.a);
        k2 = BigInteger.valueOf(2).multiply(p.y);
        if (k1.compareTo(BigInteger.ZERO) < 0)
            k1 = k1.add(p.curveParam);
        if (k2.compareTo(BigInteger.ZERO) < 0)
            k2 = k2.add(p.curveParam);
        BigInteger k2Rev = extendedEuclid(p, k2);
        lyambda = k1.multiply(k2Rev).remainder(p.curveParam)/*param(number of curve*/;
        if (lyambda.compareTo(BigInteger.ZERO) < 0){
            lyambda = lyambda.add(p.curveParam);
        }
      /*  System.out.println("lyambdasGCD:" + k2Rev);
        System.out.println("lyambda:" + lyambda);
        System.out.println("k1:" + k1);
        System.out.println("k2:" + k2);*/


        return lyambda;
    }

    //лямбда над 2мя точками
    public BigInteger lyambdaCalculationDifPoints(ECPoint p1, ECPoint p2){
        BigInteger lyambda;
        BigInteger k1,k2;
        k1 = p2.y.subtract(p1.y);
        k2 = p2.x.subtract(p1.x);
        if (k1.compareTo(BigInteger.ZERO) < 0){
            k1 = k1.add(p1.curveParam);
        }
        if (k2.compareTo(BigInteger.ZERO) < 0){
            k2 = k2.add(p1.curveParam);
        }
        BigInteger k2Rev = extendedEuclid(p1, k2);
        lyambda = k1.multiply(k2Rev).remainder(p1.curveParam)/*param(number of curve*/;
        if (lyambda.compareTo(BigInteger.ZERO) < 0){
            lyambda = lyambda.add(p1.curveParam);
        }
        /*System.out.println("lyambda:" + lyambda);
        System.out.println("k1:" + k1);
        System.out.println("k2:" + k2);*/

        return lyambda;
    }
}
