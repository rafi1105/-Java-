/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculatorapplication;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author RAFI KABIR
 */
public class CalculatorApplication {
    JFrame frame = new JFrame ("Calculator");
    // constucter 
    CalculatorApplication()
    {
        prepareGui();
    }
public void prepareGui()
{
    frame.setSize(305,510);
    frame.getContentPane().setLayout(null);
    frame.getContentPane().setBackground(Color.black);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
    public static void main(String[] args) {        // TODO code application logic here
        // object of the class calculator application
         CalculatorApplication calculator= new CalculatorApplication();
    }
    
}
