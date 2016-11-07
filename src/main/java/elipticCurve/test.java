package elipticCurve;

import elipticCurve.service.CalculateHelper;

import java.math.BigInteger;

/**
 * Created by Alexey on 11.04.2016
 */
public class test {
    public static void main(String[] args){

        double res1 = (26 - 5 % 26) * (22-7) % 26;
        BigInteger r = new BigInteger("5");
        BigInteger p = new BigInteger("7");
        BigInteger res2 = r.modInverse(p);
        CalculateHelper calc = new CalculateHelper();
        //res2 = calc.extendedEuclidForCrypt(r,p);
        System.out.println(res2);
    }
}
