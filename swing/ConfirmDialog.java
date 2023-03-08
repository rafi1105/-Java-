import javax.swing.JOptionPane;
public class ConfirmDialog {
    public static void main(String[] args) {
      int choice=  JOptionPane.showConfirmDialog(null,"Do you want sign up?", "Sign Up", JOptionPane.YES_NO_OPTION);
      if (choice== JOptionPane.YES_OPTION)
      {
        String name = JOptionPane.showInputDialog(null,"Enter your name : ");
        JOptionPane.showMessageDialog(null, name + " - WELCOME","use", -1 );


      }
       else {
        JOptionPane.showMessageDialog(null, "User name", "use", -1 );
       }
    }
}
