/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cargamefinal;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hieu
 */
public class RandomLocation {
    Random random = new Random();


    
    public void randomLocation(CarGameGUI g, JPanel blockPanel, int obstacleSpeed, JLabel background, common Score, Points point){
        boolean flag = true;
        int randomlocation = random.nextInt(4) + 1;
        if(randomlocation == 1){
            blockPanel.setLocation(200, -1500);
        }else if(randomlocation == 2){
            blockPanel.setLocation(315, -1500);
        }else if(randomlocation == 3){
            blockPanel.setLocation(445, -1500);
        }else{
            blockPanel.setLocation(575, -1500);
        }
        while(flag) {
        // Di chuyển chướng ngại vật

            int x = blockPanel.getLocation().x;
            int y = blockPanel.getLocation().y + obstacleSpeed;
            blockPanel.setLocation(x, y);
            
            // Kiểm tra nếu chướng ngại vật ra khỏi giao diện, thì đặt lại vị trí ban đầu
            if (y > background.getHeight()) {
                synchronized(Score){
                Score.score += 1;
                point.setPoint(Score.score);
                point.repaint();
                }
                int randomX = random.nextInt(4) + 1;
                if(randomX == 1){

                    blockPanel.setLocation(200, -1500);
                }else if(randomX == 2){

                    blockPanel.setLocation(315, -1500);
                }else if(randomX == 3){

                    blockPanel.setLocation(445, -1500);
                }else{
             
                    blockPanel.setLocation(575, -1500);
                }
            }
            try {
                Thread.sleep(10); // Dừng 0.1 giây trước khi di chuyển chướng ngại vật tiếp theo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = judgeStop(g, blockPanel);
        }
        failureNotice(Score.score);
    }
    public boolean judgeStop(CarGameGUI g, JPanel blockPanel){
        boolean flag = true;
        
            boolean carLeftBoundary = g.carPanel.getX() <= blockPanel.getX() + blockPanel.getWidth();
            boolean carRightBoundary = g.carPanel.getX() >= blockPanel.getX() - blockPanel.getWidth();
            boolean carUpBoundary = g.carPanel.getY() <= blockPanel.getY() + blockPanel.getHeight();
            boolean carDownBoundary = g.carPanel.getY() >= blockPanel.getY() - blockPanel.getHeight();
            if(carLeftBoundary && carRightBoundary && carUpBoundary && carDownBoundary){
                flag = false;
            }
        
        return flag;
    }
    
    public void failureNotice(int score){

        
        JFrame frame = new JFrame();
        JPanel b1Panel = new JPanel();
        JPanel b2Panel = new JPanel();
        JPanel emptyPanel1 = new JPanel();
        JPanel emptyPanel2 = new JPanel();
        JPanel emptyPanel3 = new JPanel();
        JTextField Score = new JTextField();
        Score.setEditable(false);
        Score.setText("Score: " + score);
        b1Panel.setSize(100, 50);
        b1Panel.setLocation(0, 50);
        b2Panel.setSize(100, 50);
        b2Panel.setLocation(50, 50);
        
        frame.setTitle("GAME OVER");
        JButton b1 = new JButton("Exit Game");
        
        JButton b2 = new JButton("Cancel");
        b2.setSize(100, 50);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            System.exit(0);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            CarGamefinal cargamefinal = new CarGamefinal();
            frame.setVisible(false);
            
            
        }
        });
        b1Panel.add(b1);
        b2Panel.add(b2);
        frame.add(b1Panel);
        frame.add(emptyPanel1);
        frame.add(b2Panel);
        frame.add(emptyPanel2);
        frame.add(Score);
        frame.add(emptyPanel3);
        frame.setSize(300, 100);
        GridLayout gridLayout = new GridLayout(2, 3);
        frame.setLayout(gridLayout);
        frame.setVisible(true);
        frame.setResizable(false);//then the frame can't be changed
        frame.setLocationRelativeTo(null);
    }
    
    
}

