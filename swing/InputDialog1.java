package swing;
import javax.swing.JOptionPane;
public class InputDialog1{
    public static void main (String [] args)
    {
        String name = JOptionPane.showInputDialog("Enter your username: ");
        JOptionPane.showMessageDialog(null, name + " valid username", "Confirm", -1 );
    }
}