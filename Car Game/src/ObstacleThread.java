
import java.awt.Color;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Random;
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

public class ObstacleThread implements Runnable {
    private JPanel blockPanel;
    private int speed;
    private JLabel background;
    private Random random;
    private common locate;

    public ObstacleThread(JPanel blockPanel, int speed, JLabel background, common locate) {
        this.blockPanel = blockPanel;
        this.speed = speed;
        this.background = background;
        this.random = new Random();
        this.locate = locate;
    }

    @Override
    public void run() {
        int randomLocation = random.nextInt(2) + 1;
        if(randomLocation == 1){
            blockPanel.setLocation(145, -150);
        }else{
            blockPanel.setLocation(285, -150);
        }
        while (true) {
            // Di chuyển chướng ngại vật
            int x = blockPanel.getLocation().x;
            int y = blockPanel.getLocation().y + speed;
            blockPanel.setLocation(x, y);
            synchronized(locate){
               
            // Kiểm tra nếu chướng ngại vật ra khỏi giao diện, thì đặt lại vị trí ban đầu
                if (y > background.getHeight() + 500) {        
                    int randomX = random.nextInt(4) + 1;
                    if(randomX == 1){
                        locate.n = randomX;
                        blockPanel.setLocation(205, -150);
                    }else if(randomX == 2){
                        locate.n = randomX;
                        blockPanel.setLocation(315, -150);
                    }else if(randomX == 3){
                        locate.n = randomX;
                        blockPanel.setLocation(445, -150);
                    }else{
                        locate.n = randomX;
                        blockPanel.setLocation(575, -150);
                    }
                }
                try {
                    Thread.sleep(10); // Dừng 0.1 giây trước khi di chuyển chướng ngại vật tiếp theo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ObstacleThread1 implements Runnable {
    private JPanel blockPanel;
    private int speed;
    private JLabel background;
    private Random random;
    private common locate;

    public ObstacleThread1(JPanel blockPanel, int speed, JLabel background, common locate) {
        this.blockPanel = blockPanel;
        this.speed = speed;
        this.background = background;
        this.random = new Random();
        this.locate = locate;
    }

    @Override
    public void run() {
        int randomLocation = random.nextInt(2) + 1;
        if(randomLocation == 1){
            blockPanel.setLocation(145, -150);
        }else{
            blockPanel.setLocation(285, -150);
        }
        while (true) {
            // Di chuyển chướng ngại vật
            int x = blockPanel.getLocation().x;
            int y = blockPanel.getLocation().y + speed;
            blockPanel.setLocation(x, y);

            // Kiểm tra nếu chướng ngại vật ra khỏi giao diện, thì đặt lại vị trí ban đầu
            synchronized(locate){
               
            // Kiểm tra nếu chướng ngại vật ra khỏi giao diện, thì đặt lại vị trí ban đầu
                if (y > background.getHeight() + 500) {        
                    int randomX = random.nextInt(4) + 1;
                    while(locate.n == randomX){
                        randomX = random.nextInt(4) + 1;
                    }
                    if(randomX == 1){
                        locate.n = randomX;
                        blockPanel.setLocation(205, -150);
                    }else if(randomX == 2){
                        locate.n = randomX;
                        blockPanel.setLocation(315, -150);
                    }else if(randomX == 3){
                        locate.n = randomX;
                        blockPanel.setLocation(445, -150);
                    }else{
                        locate.n = randomX;
                        blockPanel.setLocation(575, -150);
                    }
                }
                try {
                    Thread.sleep(10); // Dừng 0.1 giây trước khi di chuyển chướng ngại vật tiếp theo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ObstacleThread2 implements Runnable {
    private JPanel blockPanel;
    private int speed;
    private JLabel background;
    private Random random;
    private common locate;

    public ObstacleThread2(JPanel blockPanel, int speed, JLabel background, common locate) {
        this.blockPanel = blockPanel;
        this.speed = speed;
        this.background = background;
        this.random = new Random();
        this.locate = locate;
    }

    @Override
    public void run() {
        int randomLocation = random.nextInt(2) + 1;
        if(randomLocation == 1){
            blockPanel.setLocation(145, -150);
        }else{
            blockPanel.setLocation(285, -150);
        }
        while (true) {
            // Di chuyển chướng ngại vật
            int x = blockPanel.getLocation().x;
            int y = blockPanel.getLocation().y + speed;
            blockPanel.setLocation(x, y);

            // Kiểm tra nếu chướng ngại vật ra khỏi giao diện, thì đặt lại vị trí ban đầu
            if (y > background.getHeight() + 500) {        
                int randomX = random.nextInt(4) + 1;
                while(locate.n == randomX){
                        randomX = random.nextInt(4) + 1;
                }
                if(randomX == 1){
                    blockPanel.setLocation(205, -150);
                }else if(randomX == 2){
                    blockPanel.setLocation(315, -150);
                }else if(randomX == 3){
                    blockPanel.setLocation(445, -150);
                }else{
                    blockPanel.setLocation(575, -150);
                }
                
            }
            try {
                Thread.sleep(10); // Dừng 0.1 giây trước khi di chuyển chướng ngại vật tiếp theo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class common {
    int n = 0;
}