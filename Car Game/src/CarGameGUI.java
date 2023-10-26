
import java.awt.Color;
import javax.swing.JFrame;
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
    public CarGameGUI(){
        initGUI();
    }
    public void initGUI(){
        fr = new JFrame("Car Game");
        carPanel = new JPanel(null);
        carPanel.setSize(120,120);
        fr.add(carPanel);
        //change color of carGame
        fr.setBackground(Color.red);
        
        fr.setSize(800, 500);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
    }
}
