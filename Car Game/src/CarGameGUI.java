
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
public class CarGameGUI extends JFrame{
    JFrame fr;
    JPanel carPanel;
    JPanel blockPanel1;
    JPanel blockPanel2;
    JPanel blockPanel3;
    CarHandler chd;
    JLabel background;
    int speed;
    int width;
    int height;
    public CarGameGUI(JFrame previousFrame){
        speed = 5;
        width = 840;
        height = 650;
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
        blockPanel1 = new JPanel();
        blockPanel1.setSize(70, 160);
        blockPanel2 = new JPanel();
        blockPanel2.setSize(70, 160);
        blockPanel3 = new JPanel();
        blockPanel3.setSize(70, 160);
        // blockPanel.setBackground(Color.red); 
        //blockPanel.setLocation(285, -150);
        JLabel car = new JLabel("", new ImageIcon("car.png"), JLabel.CENTER);
        JLabel car1 = new JLabel("", new ImageIcon("car1.png"), JLabel.CENTER);
        JLabel car2 = new JLabel("", new ImageIcon("car2.png"), JLabel.CENTER);
        JLabel car3 = new JLabel("", new ImageIcon("car3.png"), JLabel.CENTER);
        
        // add this label in carPanel
        blockPanel1.add(car1);
        blockPanel2.add(car2);
        blockPanel3.add(car3);
        carPanel.add(car);
        carPanel.setLocation(background.getWidth() / 2 - carPanel.getWidth() / 2, background.getHeight() - carPanel.getHeight());
        Color CarBG = Color.decode("#464646");
        //carPanel.setBackground(Color.blue);
        carPanel.setBackground(CarBG);
        blockPanel1.setBackground(CarBG);
        blockPanel2.setBackground(CarBG);
        blockPanel3.setBackground(CarBG);
        background.add(carPanel);
        background.add(blockPanel1);
        background.add(blockPanel2);
        background.add(blockPanel3);
        common locate = new common();
        ObstacleThread blockThread1 = new ObstacleThread(blockPanel1, speed, background, locate);
        Thread thread1 = new Thread(blockThread1);
        thread1.start();
        try {
        // Tạm dừng thread2 trong 3 giây
        Thread.sleep(5000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        ObstacleThread1 blockThread2 = new ObstacleThread1(blockPanel2, speed, background, locate);
        Thread thread2 = new Thread(blockThread2);
        thread2.start();
        try {
        // Tạm dừng thread2 trong 3 giây
        Thread.sleep(10000);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        ObstacleThread2 blockThread3 = new ObstacleThread2(blockPanel3, speed, background, locate);
        Thread thread3 = new Thread(blockThread3);
        thread3.start();
        fr.setSize(840, 650);
        fr.setVisible(true);
        fr.setResizable(false);//then the frame can't be changed
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(chd);// add keylistener to frame
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
