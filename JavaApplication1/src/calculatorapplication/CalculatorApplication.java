
package calculatorapplication;
import javax.swing.*;
import java.awt.*;

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
