package elipticCurve.errors;

/**
 * Created by Alexey on 03.04.2016
 */
public class ErrorCheckEC {
    boolean result;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    String errMsg;
}
