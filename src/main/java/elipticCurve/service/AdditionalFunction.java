package elipticCurve.service;

import elipticCurve.model.TripleValue;

/**
 * Created by Alexey on 09.02.2016
 */
public class AdditionalFunction {
    //методы созданые в ходе работы, но которые устарели хранятся тут
    public int gcd(int k1, int k2){

        int higherK=0,lowerK=0;
        if (Math.abs(k1)>=Math.abs(k2)){
            higherK = Math.abs(k1);
            lowerK = Math.abs(k2);
        }
        if (Math.abs(k1)<=Math.abs(k2)){
            higherK = Math.abs(k2);
            lowerK = Math.abs(k1);
        }
        //int gcd = higherK % lowerK;
        int gcd = 0;
        int a = 0;
        int b = 1;
        if(higherK != 0 && lowerK!=0){
            while (b!=0){
                a = higherK / lowerK;
                b = higherK - lowerK * a;
                higherK = lowerK;
                lowerK = b;
            }
        } else {
            higherK = 1;
        }

        gcd = higherK;
        System.out.println("gcd " + gcd);
        return gcd;
    }

    /*public int ferma(ECPoint p, int k2){
        int aRev;
        int fi = p.curveParam-1;
        System.out.println("fi " + fi);
        aRev = (int)Math.pow(k2,fi-1);
        aRev = aRev % p.curveParam;
        System.out.println("Math.pow(k2,fi-1) " + Math.pow(k2,fi-1));
        return aRev;
    }*/

    /*public int extendedEuclid1(ECPoint p, int k2){
        int x, x1=1, x2=0, x3;
        int y=0, y1=0, y2=1, y3;
        int r, r1 = p.curveParam, r2 = k2, r3=1;
        int q, d;
        while(r3 != 0){
            q = (int) (r1 / r2);
            r3 = r1 - q * r2;
            x3 = x1 - q * x2;
            y3 = y1 - q * y2;
            r1 = r2;
            r2 = r3;
            x1 = x2;
            x2 = x3;
            y1 = y2;
            y2 = y3;
            d = r1;
            x = x1;
            y = y1;
        }
        System.out.println("********** y " + y);
        return y;
    }*/
    /*public int extendedEuclid(ECPoint p, int k2){
        TripleValue first = new TripleValue(1, 0, p.curveParam);
        TripleValue second = new TripleValue(0, 1, k2);
        TripleValue third = new TripleValue(0, 0, 1);
        int x, r, q, d;
        int y = 0;
        while(third.r != 0){
            q = (int) (first.r / second.r);
            third.r = first.r - q * second.r;
            third.x = first.x - q * second.x;
            third.y = first.y - q * second.y;
            replaceVariable(first, second, third);
            d = first.r;
            x = first.x;
            y = first.y;
        }
        System.out.println("********** y " + y);
        return y;
    }*/
    private void replaceVariable(TripleValue first, TripleValue second, TripleValue third){
        first.r = second.r;
        second.r = third.r;
        first.x = second.x;
        second.x = third.x;
        first.y = second.y;
        second.y = third.y;
    }
}
