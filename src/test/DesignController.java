/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author humay
 */
public class DesignController implements Initializable {

    @FXML
    private Button add;
    @FXML
    private TextField num1;
    @FXML
    private TextField num2;
    @FXML
    private Button subtraction;
    @FXML
    private Button multiplication;
    @FXML
    private TextField result;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addbtn(ActionEvent event) {
        String number1 = num1.getText();
        String number2 = num2.getText();
        double d1 = Double.parseDouble(number1);
        double d2 = Double.parseDouble(number2);
        result.setText("" + (d1 + d2));
    }

    @FXML
    private void subbtn(ActionEvent event) {
        String number1 = num1.getText();
        String number2 = num2.getText();
        double d1 = Double.parseDouble(number1);
        double d2 = Double.parseDouble(number2);
        result.setText("" + (d1 - d2));
    }

    @FXML
    private void multiplybtn(ActionEvent event) {
        String number1 = num1.getText();
        String number2 = num2.getText();
        double d1 = Double.parseDouble(number1);
        double d2 = Double.parseDouble(number2);
        result.setText("" + (d1 * d2));
    }
    
}
