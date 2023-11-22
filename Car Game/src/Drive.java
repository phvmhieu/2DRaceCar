
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hieu
 */
public class Drive extends JFrame{
    private JButton openButton;
    public Drive(){
        setTitle("Main Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        openButton = new JButton("Open Second Frame");
        openButton.addActionListener(e -> {
            CarGameGUI game = new CarGameGUI(this);
            this.setVisible(false);
        });
        JPanel panel = new JPanel();
        panel.add(openButton);
        add(panel);
    }
    public static void main(String[] args) {
        //Create CarGameGUI object
        SwingUtilities.invokeLater(() -> {
            Drive mainFrame = new Drive();
            mainFrame.setVisible(true);
        });
        
    }
}
