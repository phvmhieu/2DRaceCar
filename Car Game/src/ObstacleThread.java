
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

    public ObstacleThread(JPanel blockPanel, int speed, JLabel background) {
        this.blockPanel = blockPanel;
        this.speed = speed;
        this.background = background;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            // Di chuyển chướng ngại vật
            int x = blockPanel.getLocation().x;
            int y = blockPanel.getLocation().y + speed;
            blockPanel.setLocation(x, y);

            // Kiểm tra nếu chướng ngại vật ra khỏi giao diện, thì đặt lại vị trí ban đầu
            if (y > background.getHeight()) {        
                int randomX = random.nextInt(2) + 1;
                if(randomX == 1){
                    blockPanel.setLocation(145, -150);
                }else{
                    blockPanel.setLocation(285, -150);
                }
                
            }
            try {
                Thread.sleep(100); // Dừng 0.1 giây trước khi di chuyển chướng ngại vật tiếp theo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Block {
    int x;
    int y;
    public Block(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setter(int x, int y){
        this.x = x;
        this.y = y;
    }
    
}