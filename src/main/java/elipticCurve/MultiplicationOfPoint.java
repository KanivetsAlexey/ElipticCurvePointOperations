package elipticCurve;

import elipticCurve.errors.ErrorCheckEC;
import elipticCurve.model.ECPoint;
import elipticCurve.model.RetValForCrypt;
import elipticCurve.service.OperationOnEC;
import elipticCurve.service.impl.OperationOnECImpl;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Alexey on 08.01.2016
 */
public class MultiplicationOfPoint extends SymmetricAlgorithm {
        OperationOnEC operationOnEC;
    public/* static */BigInteger pValue = new BigInteger(arg.curveParamP.getText().toString());
    public StringBuilder textEncr = new StringBuilder();
    public MultiplicationOfPoint(MainController arg) {
        super(arg);
        operationOnEC = new OperationOnECImpl();
    }

    public void multiplication(int indexOfTab){

        String result;
        ECPoint p1 = null;
        ECPoint p2 = null;
        ECPoint resultPoint = null;
        BigInteger mulParamN;

        switch(indexOfTab){
            case 0:
                ErrorCheckEC chX = checkEC(arg.pointParamX.getText().toString(),"X для точки А");
                if(!chX.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chX.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                ErrorCheckEC chY = checkEC(arg.pointParamY.getText().toString(),"Y для точки А");
                if(!chY.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chY.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                p1 = fillPoint(arg, arg.pointParamX, arg.pointParamY);
                ErrorCheckEC chp1 = checkPoint(p1);
                if(!chp1.isResult()){
                    JOptionPane.showMessageDialog(null, "Точка А не принадлежит данной кривой.", chp1.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                    break;
                }
                ErrorCheckEC chX2 = checkEC(arg.pointParamX.getText().toString(),"X для точки В");
                if(!chX.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chX2.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                ErrorCheckEC chY2 = checkEC(arg.pointParamY.getText().toString(),"Y для точки В");
                if(!chY.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chY2.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                p2 = fillPoint(arg, arg.pointParamX2, arg.pointParamY2);
                ErrorCheckEC chp2 = checkPoint(p2);
                if(!chp2.isResult()){
                    JOptionPane.showMessageDialog(null, "Точка В не принадлежит данной кривой.", chp2.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                    break;
                }
                resultPoint = operationOnEC.calculateSumOfPoint(p1, p2);
                break;
            case 1:
                ErrorCheckEC chX5 = checkEC(arg.pointParamX5.getText().toString(),"X для точки А");
                if(!chX5.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chX5.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                ErrorCheckEC chY5 = checkEC(arg.pointParamY5.getText().toString(),"Y для точки А");
                if(!chY5.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chY5.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                p1 = fillPoint(arg, arg.pointParamX5, arg.pointParamY5);
                ErrorCheckEC chp11 = checkPoint(p1);
                if(!chp11.isResult()){
                    JOptionPane.showMessageDialog(null, "Точка А не принадлежит данной кривой.", chp11.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                    break;
                }
                ErrorCheckEC chX6 = checkEC(arg.pointParamX6.getText().toString(),"X для точки В");
                if(!chX6.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chX6.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                ErrorCheckEC chY6 = checkEC(arg.pointParamY6.getText().toString(),"Y для точки В");
                if(!chY6.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chY6.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                p2 = fillPoint(arg, arg.pointParamX6, arg.pointParamY6);
                ErrorCheckEC chp12 = checkPoint(p1);
                if(!chp12.isResult()){
                    JOptionPane.showMessageDialog(null, "Точка В не принадлежит данной кривой.", chp12.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                    break;
                }
                resultPoint = operationOnEC.calculateDifference(p1, p2);
                break;
            case 2:
                ErrorCheckEC chX3 = checkEC(arg.pointParamX3.getText().toString(),"X");
                if(!chX3.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chX3.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                ErrorCheckEC chY3 = checkEC(arg.pointParamY3.getText().toString(),"Y");
                if(!chY3.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chY3.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                p1 = fillPoint(arg, arg.pointParamX3, arg.pointParamY3);
                ErrorCheckEC chp13 = checkPoint(p1);
                if(!chp13.isResult()){
                    JOptionPane.showMessageDialog(null, "Точка А не принадлежит данной кривой.", chp13.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                    break;
                }
                resultPoint = operationOnEC.calculateDoubling(p1);
                break;
            case 3:
                ErrorCheckEC chX4 = checkEC(arg.pointParamX4.getText().toString(),"X");
                if(!chX4.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chX4.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                ErrorCheckEC chY4 = checkEC(arg.pointParamY4.getText().toString(),"Y");
                if(!chY4.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chY4.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                p1 = fillPoint(arg, arg.pointParamX4, arg.pointParamY4);
                ErrorCheckEC chp14 = checkPoint(p1);
                if(!chp14.isResult()){
                    JOptionPane.showMessageDialog(null, "Точка А не принадлежит данной кривой.", chp14.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                    break;
                }
                ErrorCheckEC chMul = checkEC(arg.mulParamN.getText().toString(),"N");
                if(!chMul.isResult()){
                    JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chMul.getErrMsg(), JOptionPane.ERROR_MESSAGE);
                }
                mulParamN = new BigInteger(arg.mulParamN.getText());
                resultPoint = operationOnEC.calculateMultiply(p1, mulParamN);
                break;
        }
        result = formResult(resultPoint);
        arg.result.setText(result);
    }

    private String formResult(ECPoint ecPoint){
        if (ecPoint != null){
            return String.valueOf(ecPoint.x) + "," + String.valueOf(ecPoint.y);
        }
        return "";
    }

    private BigInteger parsePointValue(TextField textField){
        return new BigInteger(textField.getText());
    }

    private ECPoint fillPoint(MainController arg, TextField field1, TextField field2){
        ECPoint ecPoint = new ECPoint();
        ecPoint.x =  parsePointValue(field1);
        ecPoint.y =  parsePointValue(field2);
        ecPoint.a =  parsePointValue(arg.curveParamA);
        ecPoint.b =  parsePointValue(arg.curveParamB);
        ecPoint.curveParam =  parsePointValue(arg.curveParamP);
        return ecPoint;
    }
    public void check(){
        String a = arg.curveParamA.getText().toString(),
               b = arg.curveParamB.getText().toString(),
               p = arg.curveParamP.getText().toString(),
               ec = "";
        String msg = "";
        ErrorCheckEC chA = checkEC(a,"a");
        ErrorCheckEC chB = checkEC(b,"b");
        ErrorCheckEC chP = checkEC(p,"p");

        BigInteger paramP = BigInteger.ZERO;
        BigInteger paramA = BigInteger.ZERO;
        BigInteger paramB = BigInteger.ZERO;


        if(!chP.isResult()){
            JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chP.getErrMsg(), JOptionPane.ERROR_MESSAGE);
        }else{
            paramP = new BigInteger(p);
            ErrorCheckEC checkP = checkP(paramP);
            if(!checkP.isResult()){
                JOptionPane.showMessageDialog(null, "Параметр 'p' не отвечает данной кривой", checkP.getErrMsg(), JOptionPane.ERROR_MESSAGE);
            }
        }
        if(!chA.isResult()){
            JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chA.getErrMsg(), JOptionPane.ERROR_MESSAGE);
        }else{
            paramA = new BigInteger(a);
            ErrorCheckEC checkA = checkA(paramA, paramP);
            if(!checkA.isResult()){
                JOptionPane.showMessageDialog(null, "Параметр 'а' не отвечает данной кривой", checkA.getErrMsg(), JOptionPane.ERROR_MESSAGE);
            }
        }

        if(!chB.isResult()){
            JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chB.getErrMsg(), JOptionPane.ERROR_MESSAGE);
        }else{
            paramB = new BigInteger(b);
            ErrorCheckEC checkB = checkB(paramB, paramP);
            if(!checkB.isResult()){
                JOptionPane.showMessageDialog(null, "Параметр 'b' не отвечает данной кривой", checkB.getErrMsg(), JOptionPane.ERROR_MESSAGE);
            }
        }
        ErrorCheckEC checkEC = checkcEC(paramA, paramB, paramP);
        if(!checkEC.isResult()){
            JOptionPane.showMessageDialog(null, "Сочитание параметров не подходит для данной кривой.", checkEC.getErrMsg(), JOptionPane.ERROR_MESSAGE);
        }


        //return;
    }
    private ErrorCheckEC checkEC(String str,String name){
        ErrorCheckEC err = new ErrorCheckEC();
        try{
            BigInteger num = new BigInteger(str);
            err.setResult(true);
        } catch (NumberFormatException e) {
            err.setResult(false);
            err.setErrMsg("Число " + name + " не целое!");
        }
        return err;
    }


    private ErrorCheckEC checkA(BigInteger a, BigInteger p){
        ErrorCheckEC err = new ErrorCheckEC();
        if(!a.remainder(p).equals(BigInteger.ZERO)){
            err.setResult(true);
            err.setErrMsg("Условие выполнено");
        }else{
            err.setResult(false);
            err.setErrMsg("Условие не выполнено");
        }
        return err;
    }

    private ErrorCheckEC checkB(BigInteger b, BigInteger p){
        ErrorCheckEC err = new ErrorCheckEC();
        if(!b.remainder(p).equals(BigInteger.ZERO)){
            err.setResult(true);
            err.setErrMsg("Условие выполнено");
        }else{
            err.setResult(false);
            err.setErrMsg("Условие не выполнено");
        }
        return err;
    }

    private ErrorCheckEC checkcEC(BigInteger a, BigInteger b, BigInteger p){
        ErrorCheckEC err = new ErrorCheckEC();
        BigInteger part1 = BigInteger.valueOf(4).multiply(a.pow(3));
        BigInteger part2 = BigInteger.valueOf(27).multiply(b.pow(2));
        BigInteger checkEC = part1.add(part2);
        if(!checkEC.remainder(p).equals(BigInteger.ZERO)){
            err.setResult(true);
            err.setErrMsg("Условие выполнено");
        }else{
            err.setResult(false);
            err.setErrMsg("Условие не выполнено");
        }
        return err;
    }

    private ErrorCheckEC checkPoint(ECPoint p){
        ErrorCheckEC err = new ErrorCheckEC();
        BigInteger left = p.y.pow(2).remainder(p.curveParam);
        BigInteger right = (p.x.pow(3).add(p.a.multiply(p.x)).add(p.b)).remainder(p.curveParam);
        if(left.equals(right)){
            err.setResult(true);
            err.setErrMsg("Проверка точки прошла успешно");
        }else{
            err.setResult(false);
            err.setErrMsg("Точка не пренадлежит данной кривой");
        }
        return err;
    }

    private ErrorCheckEC checkP(BigInteger p){
        ErrorCheckEC err = new ErrorCheckEC();
        boolean pChecker = isPrime(p);
        if(pChecker){
            err.setResult(true);
            err.setErrMsg("Условие выполнено");
        }else{
            err.setResult(false);
            err.setErrMsg("Условие не выполнено");
        }
        return err;
    }

    private boolean isPrime(BigInteger N) {
        if (N.compareTo(BigInteger.valueOf(2)) < 0) return false;
        for (BigInteger i = BigInteger.valueOf(2); N.compareTo(i.multiply(i)) >= 0; i = i.add(BigInteger.ONE)){
            if (N.remainder(i).equals(BigInteger.ZERO))
                return false;
        }
        return true;
    }

    public RetValForCrypt encrypt(){
        StringBuilder result = new StringBuilder();
        ArrayList<Character> alphabet = createAlphabet();
        Map<Character, Integer> alphabetMap = createAlphabetMap();
        BigInteger curveParamQ = new BigInteger(arg.curveParamQ.getText().toString());
        ErrorCheckEC chQ = checkEC(arg.curveParamQ.getText().toString(),"Q");
        if(!chQ.isResult()){
            JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chQ.getErrMsg(), JOptionPane.ERROR_MESSAGE);
        }
        char[] text = arg.text.getText().toCharArray();
        ECPoint pointG = null;
        ErrorCheckEC chX = checkEC(arg.pointGX.getText().toString(),"X");
        if(!chX.isResult()){
            JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chX.getErrMsg(), JOptionPane.ERROR_MESSAGE);
        }
        ErrorCheckEC chY = checkEC(arg.pointGY.getText().toString(),"Y");
        if(!chY.isResult()){
            JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chY.getErrMsg(), JOptionPane.ERROR_MESSAGE);
        }
        pointG = fillPoint(arg, arg.pointGX, arg.pointGY);
        //BigInteger secretKey = null;
        ErrorCheckEC chSCINT = checkEC(arg.secretKey.getText().toString(),"SC");
        if(!chSCINT.isResult()){
            JOptionPane.showMessageDialog(null, "Секретный ключ должен быть целым числом.", chSCINT.getErrMsg(), JOptionPane.ERROR_MESSAGE);
        }
        BigInteger secretKey = new BigInteger(arg.secretKey.getText().toString());

        ErrorCheckEC chSC = checkSecretKey(curveParamQ, secretKey);
        if(!chSC.isResult()){
            JOptionPane.showMessageDialog(null, "Секретный ключ должен быть от 0 до q.", chSC.getErrMsg(), JOptionPane.ERROR_MESSAGE);
        }
        ECPoint Db = operationOnEC.calculateMultiply(pointG, secretKey);
        System.out.println("DB x" + Db.x );
        System.out.println("DB y" + Db.y );
        BigInteger randK = getRandomBigInteger(curveParamQ);
        System.out.println("rand" + randK);
        ECPoint R = operationOnEC.calculateMultiply(pointG, randK);
        ECPoint P = operationOnEC.calculateMultiply(Db, randK);
        ArrayList<ECPoint> encRes = new ArrayList<ECPoint>();
        for(char letter: text) {
            if (alphabet.indexOf(letter) != -1) {
                ECPoint encNum = new ECPoint();
                BigInteger numberOfLetter = new BigInteger(alphabetMap.get(letter).toString());
                BigInteger e = numberOfLetter.multiply(P.x).remainder(P.curveParam);
                encNum.a = e;
                textEncr.append(e);
                int index = e.intValue() % alphabet.size();
                encNum.b = new BigInteger(String.valueOf(index));
                encRes.add(encNum);
                result.append(alphabet.get(index));
            }else {
                result.append(letter);
            }
        }
        //BigInteger e = text.multiply(P.x).remainder(P.curveParam);
        //result.append(e);
        /*result.append(Db.x);
        result.append(Db.y);*/
        arg.resultEnc.setText(result.toString());
        RetValForCrypt ret = new RetValForCrypt(Db,R,secretKey,encRes);
        return ret;
    }
    public void decrypt(RetValForCrypt ret){
        StringBuilder result = new StringBuilder();
        ArrayList<Character> alphabet = createAlphabet();
        Map<Character, Integer> alphabetMap = createAlphabetMap();
        BigInteger curveParamQ = new BigInteger(arg.curveParamQ.getText().toString());
        ErrorCheckEC chQ = checkEC(arg.curveParamQ.getText().toString(),"Q");
        ArrayList<ECPoint> encRes = ret.encRes;
        if(!chQ.isResult()){
            JOptionPane.showMessageDialog(null, "Данный параметр должен быть целым числом.", chQ.getErrMsg(), JOptionPane.ERROR_MESSAGE);
        }
        char[] text = arg.resultEnc.getText().toCharArray();
        ArrayList<BigInteger> text1 = null;
        //ECPoint Db = ret.Db;
        //ECPoint R = ret.R;
        //BigInteger secretKey = ret.secretKey;
        System.out.println("Rx " + ret.R.x);
        System.out.println("Ry " + ret.R.y);
        ECPoint Q = operationOnEC.calculateMultiply(ret.R,ret.secretKey);
        System.out.println("Qx " + Q.x);
        System.out.println("Text " + text);
        String textb =  arg.text.getText().toString();
        for(ECPoint point:encRes){
            text1.add(point.a);
        }
        if(textb.length() == 0){
            BigInteger xInverse = Q.x.modInverse(Q.curveParam);
            for(BigInteger num: text1){
                BigInteger msg = num.multiply(xInverse).remainder(Q.curveParam);
                result.append(alphabet.get(msg.intValue()));
            }
        }else{
            try {
                BigInteger xInverse = Q.x.modInverse(Q.curveParam);
                for(char letter: text) {
                    if (alphabet.indexOf(letter) != -1) {
                        BigInteger numberOfLetter = new BigInteger(alphabetMap.get(letter).toString());
                        BigInteger msg = numberOfLetter.multiply(xInverse).remainder(Q.curveParam);
                        int index = msg.intValue() % alphabet.size();
                        result.append(alphabet.get(index));
                    }else {
                        result.append(letter);
                    }
                }
            } catch (ArithmeticException e){
                System.out.println(Q.x + " by mod " + Q.curveParam);
                throw e;
            }
        }
        //BigInteger resu = text.multiply(xInverse).remainder(Q.curveParam);
        //BigInteger resBI = new BigInteger(resMod.toString());
        //result.append(resu.toString());
        arg.resultEnc.setText(result.toString());
    }
    private ErrorCheckEC checkSecretKey(BigInteger q, BigInteger secretKey){
        ErrorCheckEC err = new ErrorCheckEC();
        boolean scChecker;
        if((secretKey.compareTo(BigInteger.ZERO) == 1) && (secretKey.compareTo(q) == -1)){
            scChecker = true;
        } else {
            scChecker = false;
        }
        if(scChecker){
            err.setResult(true);
            err.setErrMsg("Условие выполнено");
        }else{
            err.setResult(false);
            err.setErrMsg("Условие не выполнено");
        }
        return err;
    }

    public BigInteger getRandomBigInteger(BigInteger n) {
        Random rand = new Random();
        int maxNumBitLength = n.bitLength();
        BigInteger aRandomBigInt;

        do {
            aRandomBigInt = new BigInteger(maxNumBitLength, rand);
            // compare random number lessthan ginven number
        } while (aRandomBigInt.compareTo(n) > 0);
        if (aRandomBigInt.compareTo(BigInteger.ZERO) == 0) {
            do {
                aRandomBigInt = new BigInteger(maxNumBitLength, rand);
                // compare random number lessthan ginven number
            } while (aRandomBigInt.compareTo(n) > 0);
        }
        if(aRandomBigInt.compareTo(pValue) == 0){
            do {
                aRandomBigInt = new BigInteger(maxNumBitLength, rand);
                // compare random number lessthan ginven number
            } while (aRandomBigInt.compareTo(n) > 0);
        }
        return aRandomBigInt;
    }
    private ArrayList<Character> createAlphabet(){
        ArrayList<Character> alphabet= new ArrayList<Character>();
        alphabet.add('Ĉ');
        for(char ch='А';ch<='я';ch++) {
            alphabet.add(ch);
        }
        for(char ch=' ';ch<='@';ch++) {
            alphabet.add(ch);
        }
        for(char ch='A';ch<='z';ch++) {
            alphabet.add(ch);
        }
        System.out.println(alphabet.toString());
        System.out.println(alphabet.size());
        return alphabet;
    }
    private Map<Character, Integer> createAlphabetMap(){
        Map<Character, Integer> alphabetMap = new HashMap<Character, Integer>();
        int numLetter = 0;
        alphabetMap.put('Ĉ', numLetter++);
        for(char ch='А';ch<='я';ch++) {
            alphabetMap.put(ch, numLetter++);
        }
        for(char ch=' ';ch<='@';ch++) {
            alphabetMap.put(ch, numLetter++);
        }

        for(char ch='A';ch<='z';ch++) {
            alphabetMap.put(ch, numLetter++);
        }


        return alphabetMap;
    }

    public ArrayList<ECPoint> genPoints(){
        BigInteger aV = new BigInteger(arg.curveParamA.getText().toString());
        BigInteger bV = new BigInteger(arg.curveParamB.getText().toString());
        BigInteger pV = new BigInteger(arg.curveParamP.getText().toString());

        ArrayList<ECPoint> resList = new ArrayList<ECPoint>();
        for(BigInteger i = BigInteger.ZERO; i.compareTo(pV) < 0;i = i.add(BigInteger.ONE)){
            for(BigInteger j = BigInteger.ZERO; j.compareTo(pV) < 0; j = j.add(BigInteger.ONE)){
                ECPoint curGen = new ECPoint();
                curGen.x =  i;
                curGen.y =  j;
                curGen.a =  parsePointValue(arg.curveParamA);
                curGen.b =  parsePointValue(arg.curveParamB);
                curGen.curveParam =  parsePointValue(arg.curveParamP);
                ErrorCheckEC chCurPoint = checkPoint(curGen);
                if(chCurPoint.isResult()){
                    resList.add(curGen);
                }
            }
        }BigInteger countOfPoints = BigInteger.ZERO;
        BigInteger listSize = new BigInteger(String.valueOf(resList.size()));
        for( BigInteger g = BigInteger.ZERO; g.compareTo(listSize) < 0 ;g = g.add(BigInteger.ONE)){
            ECPoint cur = resList.get(g.intValue());
            System.out.println("Point " + g + ": " + "(" + cur.x + ";" + cur.y + ")");
            countOfPoints = g;
        }
        boolean chR = false;
        do{
        boolean ch = isPrime(countOfPoints);
            if(ch == false){
                countOfPoints = countOfPoints.add(BigInteger.ONE);
            }else{
                chR = true;
            }
        }while (chR != true);

        arg.curveParamQ.setText(countOfPoints.toString());
        return resList;
    }
}