/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cargamefinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;


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
    Points pointPanel;
    ArrayList<JPanel> obstacles;
    private static ArrayList<Users> users;
    int obstacleSpeed;
    int userSpeed;
    int width;
    int height;
    public CarGameGUI(JFrame previousFrame) throws InterruptedException, IOException{
        obstacleSpeed = 5;
        userSpeed = 1;
        width = 840;
        height = 650;
        chd = new CarHandler(this);
        users = new ArrayList<Users>();
        ReadData();
        initGUI();
        
    }
    private void initGUI() throws InterruptedException{

        fr = new JFrame("Car Game");
        fr.setLayout(new BorderLayout());
        background = new JLabel("", new ImageIcon("images/background.gif"), JLabel.CENTER);
        background.setBounds(0, 0, width, height);
        fr.add(background);
        carPanel = new JPanel();
        carPanel.setSize(70,133);
        ArrayList<JPanel> obstacles = new ArrayList();
        
        blockPanel1 = new JPanel();
        blockPanel1.setSize(70, 150);
        obstacles.add(blockPanel1);
        blockPanel2 = new JPanel();
        blockPanel2.setSize(70, 160);
        obstacles.add(blockPanel2);
        blockPanel3 = new JPanel();
        blockPanel3.setSize(70, 160);
        obstacles.add(blockPanel3);
        // blockPanel.setBackground(Color.red); 
        //blockPanel.setLocation(285, -150);
        JLabel car = new JLabel("", new ImageIcon("images/car.png"), JLabel.CENTER);
        JLabel car1 = new JLabel("", new ImageIcon("images/car1.png"), JLabel.CENTER);
        JLabel car2 = new JLabel("", new ImageIcon("images/car2.png"), JLabel.CENTER);
        JLabel car3 = new JLabel("", new ImageIcon("images/car3.png"), JLabel.CENTER);
        JTextField score = new JTextField();
//        point = new JPanel();
//        point.add(score);
//        fr.add(point, BorderLayout.NORTH);
        //add this label in carPanel
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
        pointPanel = new Points();
        pointPanel.setSize(100, 50);
//        Timer timer = new Timer(1000, e -> {
//            int newScore = (int) (Math.random() * 100);
//            pointPanel.setPoint(newScore);
//            });
//        timer.start();
        background.add(pointPanel);
        common Score = new common();
        Obstacle1 blockThread1 = new Obstacle1(this, blockPanel1, obstacleSpeed, background, Score, pointPanel);
        Thread thread1 = new Thread(blockThread1);
        thread1.start();

        try {
        // Tạm dừng thread2 trong 3 giây
        Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        Obstacle2 blockThread2 = new Obstacle2(this, blockPanel2, obstacleSpeed, background, Score, pointPanel);
        Thread thread2 = new Thread(blockThread2);
        thread2.start();
        try {
        // Tạm dừng thread2 trong 3 giây
        Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        Obstacle3 blockThread3 = new Obstacle3(this, blockPanel3, obstacleSpeed, background, Score, pointPanel);
        Thread thread3 = new Thread(blockThread3); 
        thread3.start();

        
        fr.setSize(840, 650);
        fr.setVisible(true);
        fr.setResizable(false);//then the frame can't be changed
        fr.setLocationRelativeTo(null);
        fr.addKeyListener(chd);// add keylistener to frame
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void ReadData() throws IOException{
        try{
            FileReader fread = new FileReader("data/data.txt");
            BufferedReader br = new BufferedReader(fread);
            
            String line = null;
            while((line = br.readLine()) != null){
                String[] str = line.split(" ");
                users.add(new Users(str[0], str[1]));
            }
            
            br.close();
        }catch(IOException ex) {}
    }
}

