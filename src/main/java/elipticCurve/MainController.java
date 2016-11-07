package elipticCurve;

import elipticCurve.model.RetValForCrypt;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by Alexey on 09.12.2015
 */
public class MainController {



    @FXML
    Button mul;

    @FXML
    Button clearId;

    @FXML
    Button check;

    @FXML
    Button encrypt;

    @FXML
    Button decrypt;

    @FXML
    Button clear;

    @FXML
    TextField curveParamA;

    @FXML
    TextField curveParamB;

    @FXML
    TextField curveParamP;

    @FXML
    TextField curveParamQ;

    @FXML
    TextField pointParamX;

    @FXML
    TextField pointGX;

    @FXML
    TextField pointGY;

    @FXML
    TextField secretKey;

    @FXML
    TextField pointParamY;

    @FXML
    TextField pointParamX2;

    @FXML
    TextField pointParamY2;

    @FXML
    TextField pointParamX3;

    @FXML
    TextField pointParamY3;

    @FXML
    TextField pointParamX4;

    @FXML
    TextField pointParamY4;

    @FXML
    TextField pointParamX5;

    @FXML
    TextField pointParamY5;

    @FXML
    TextField pointParamX6;

    @FXML
    TextField pointParamY6;

    @FXML
    TextField mulParamN;

    @FXML
    TextArea text;

    @FXML
    TextArea resultEnc;

    @FXML
    TabPane tabPane;

    @FXML
    TextField result;

    @FXML
    javafx.scene.control.Label fail;

    public RetValForCrypt ret;
    public void mulAction(javafx.event.ActionEvent actionEvent) {
        MultiplicationOfPoint multiplicationOfPoint = new MultiplicationOfPoint(this);
        int indexOfTab = tabPane.getSelectionModel().getSelectedIndex();
        multiplicationOfPoint.check();
        multiplicationOfPoint.multiplication(indexOfTab);
    }

    public void checkAction(javafx.event.ActionEvent actionEvent) {
        MultiplicationOfPoint multiplicationOfPoint = new MultiplicationOfPoint(this);
        multiplicationOfPoint.check();
        multiplicationOfPoint.genPoints();
    }

    //clear funk
    public void clearAction(javafx.event.ActionEvent actionEvent) {
        mulParamN.clear();
        result.clear();
    }

    public void encryptAction(javafx.event.ActionEvent actionEvent) {
        MultiplicationOfPoint multiplicationOfPoint = new MultiplicationOfPoint(this);
        ret = multiplicationOfPoint.encrypt();
    }
    public void decryptAction(javafx.event.ActionEvent actionEvent) {
        MultiplicationOfPoint multiplicationOfPoint = new MultiplicationOfPoint(this);
        multiplicationOfPoint.decrypt(ret);
    }

    public void clear1Action(javafx.event.ActionEvent actionEvent) {
        /*mulParamN.clear();
        result.clear();*/
    }


}






