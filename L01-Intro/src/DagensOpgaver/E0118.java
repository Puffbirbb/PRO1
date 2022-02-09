package DagensOpgaver;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class E0118 {
    public static void main(String[] args) throws Exception {
        URL imageLocation = new URL("https://mpng.subpng.com/20180325/joq/kisspng-poole-versus-hal-9000-frank-poole-computer-icons-f-terminator-5ab7768dd7f0d8.0501370115219728778845.jpg");
        JOptionPane.showMessageDialog(null, "Hal 9000", "Im sorry, Dave.", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
    }
}
