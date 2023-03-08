package swing;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class messageDialog2 {
    public static void main(String[] args) {
        ImageIcon img = new ImageIcon("r.png");
        JOptionPane.showMessageDialog(null , " messageDialog all parameters", "message",JOptionPane.PLAIN_MESSAGE,img);
    }
}
