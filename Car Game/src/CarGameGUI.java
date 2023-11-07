
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hieu
 */
public class CarGameGUI {
    JFrame fr;
    JPanel carPanel;
    CarHandler chd;
    JLabel background;
    int speed;
    int width;
    int height;
    public CarGameGUI(){
        speed = 10;
        width = 500;
        height = 667;
        chd = new CarHandler(this);
        initGUI();
        
    }
    private void initGUI(){
        fr = new JFrame("Car Game");
        fr.setLayout(null);
        background = new JLabel("", new ImageIcon("background.gif"), JLabel.CENTER);
        background.setBounds(0, 0, width, height);
        fr.add(background);
        carPanel = new JPanel();
        carPanel.setSize(70,160);
        JLabel car = new JLabel("", new ImageIcon("car.png"), JLabel.CENTER);
        // add this label in carPanel
        carPanel.add(car);
        carPanel.setLocation(background.getWidth() / 2 - carPanel.getWidth() / 2, background.getHeight() - carPanel.getHeight() - 10);
        Color CarBG = Color.decode("#464646");
        //carPanel.setBackground(Color.blue);
        carPanel.setBackground(CarBG);
        background.add(carPanel);
        fr.setSize(500, 702);
        fr.setVisible(true);
        fr.setResizable(false);//then the frame can't be changed
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(chd);// add keylistener to frame
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
    }
}
