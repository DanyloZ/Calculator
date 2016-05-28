package com.Danylo.Calculator;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Calculator {
     static double calculate (double a, double b, char operator) {
        double answer = 0;
        switch (operator) {
            case '+' :
                answer = a + b;
                break;
            case '-' :
                answer = a - b;
                break;
            case 'x' :
                answer = a * b;
                break;
            case '/' :
                answer = a / b;
                break;
        }
        return answer;
    }
}
