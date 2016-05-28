package com.Danylo.Calculator;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Text out;

    private double num1;

    private boolean start = true;

    private boolean prevOperator;
    private char operator;

    @FXML
    private void processNum(ActionEvent event) {
        prevOperator = false;
        if (start) {
            out.setText("0");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        if ("0".equals(out.getText())) {
            out.setText(value);
        }
        else if ("-0".equals(out.getText())) {
            out.setText("-" + value);
        }
        else {
            out.setText(out.getText() + value);
        }
    }

    @FXML
    private void processPoint(ActionEvent event) {
        if (start) {
            out.setText("0.");
            start = false;
            return;
        }
        if (!out.getText().contains(".")) {
            out.setText(out.getText() + ".");
        }
    }

    @FXML
    private void processOperator(ActionEvent event) {
        char value = ((Button)event.getSource()).getText().charAt(0);
        if (prevOperator) {
            operator = value;
            return;
        }
        if (num1 == 0) {
            operator = value;
            num1 = Double.parseDouble(out.getText());
            start = true;
            prevOperator = true;
        }
        else {
            out.setText(String.valueOf(Calculator.calculate(num1, Double.parseDouble(out.getText()), operator)));
            if (out.getText().endsWith(".0")) {
                out.setText(out.getText().substring(0, out.getText().length() - 2));
            }
            start = true;
            num1 = Double.parseDouble(out.getText());
            operator = value;
            prevOperator = true;
        }
    }

    @FXML
    private void processEquals(ActionEvent event) {
        if (operator == 0) return;
        out.setText(Double.toString(Calculator.calculate(num1, Double.parseDouble(out.getText()), operator)));
        if (out.getText().endsWith(".0")) {
            out.setText(out.getText().substring(0, out.getText().length() - 2));
        }
        num1 = 0;
        start = true;
        operator = 0;
        prevOperator = false;
    }

    @FXML
    private void processChangeSign(ActionEvent event) {
        if (out.getText().startsWith("-")) {
            out.setText(out.getText().substring(1));
        }
        else {
            out.setText("-" + out.getText());
        }
    }

    @FXML
    private void processBackSpace(ActionEvent event) {
        if (out.getText().startsWith("-")) {
            if (out.getText().length() > 2) {
                out.setText(out.getText().substring(0, out.getText().length() - 1));
            }
            else {
                out.setText("0");
            }
        }
        else {
            if (out.getText().length() > 1) {
                out.setText(out.getText().substring(0, out.getText().length() - 1));
            }
            else {
                out.setText("0");
            }
        }
    }

    @FXML
    private void processC(ActionEvent event) {
        out.setText("0");
        num1 = 0;
        operator = 0;
    }

    @FXML
    private void processCE(ActionEvent event) {
        out.setText("0");

    }
}
