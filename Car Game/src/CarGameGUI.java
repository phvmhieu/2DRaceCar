
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
    int speed;
    public CarGameGUI(){
        speed = 20;
        chd = new CarHandler(this);
        initGUI();
        
    }
    private void initGUI(){
        fr = new JFrame("Car Game");
        fr.setLayout(null);
        carPanel = new JPanel();
        carPanel.setSize(100,170);
        JLabel car = new JLabel(new ImageIcon("car.png"));
        // add this label in carPanel
        carPanel.add(car);
        carPanel.setLocation(350, 290);
        //carPanel.setBackground(Color.blue);
        fr.add(carPanel);
        fr.setSize(800, 500);
        fr.setVisible(true);
        fr.setResizable(false);//then the frame can't be changed
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(chd);// add keylistener to frame
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
    }
}
