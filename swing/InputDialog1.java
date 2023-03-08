
import javax.swing.JOptionPane;
public class InputDialog1{
    public static void main (String [] args)
    {
        String name = JOptionPane.showInputDialog(null,"Enter your username: ", "this is tittle", JOptionPane.QUESTION_MESSAGE);
        String lname = JOptionPane.showInputDialog(null,"Enter your id: ", "this is tittle", JOptionPane.QUESTION_MESSAGE);
        String fulluser= name+ " - " + lname; 
        JOptionPane.showMessageDialog(null, "Full details :" +fulluser , "Confirm", -1 );
    }
} 