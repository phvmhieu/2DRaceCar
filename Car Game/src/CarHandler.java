
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hieu
 */
//public class CarHandler implements KeyListener{
//    CarGameGUI g;
//    public CarHandler (CarGameGUI ref){
//        this.g = ref;
//        
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        //moving car by using this method
//        //68 for right, 65 for left
//        int code = e.getKeyCode();
//        //System.out.println("Key pressed code:\t" + code);
//        if(code == 68){
//            //move right
//            System.out.println("right key pressed");
//            int x = g.carPanel.getX();
//            int y = g.carPanel.getY();
//            System.out.println("x,y \t" + x + "," + y);
//            int width = g.fr.getWidth();
//            int carWidth = g.carPanel.getWidth();
//            if(x + g.speed <= width - carWidth - 140){
//                g.carPanel.setLocation(x + g.speed, y);
//            }
//        }
//        else if(code == 65){
//            //move left
//            System.out.println("left key pressed");
//            int x = g.carPanel.getX();
//            int y = g.carPanel.getY();
//            System.out.println("x,y \t" + x + "," + y);
//            if(x - g.speed >= 140){
//                g.carPanel.setLocation(x - g.speed, y);
//            }
//        }else if(code == 87) {
//            //move front
//            System.out.println("front key pressed");
//            int x = g.carPanel.getX();
//            int y = g.carPanel.getY();
//            System.out.println("x,y \t" + x + "," + y);
//            if(y - g.speed >= 0){
//                g.carPanel.setLocation(x, y - g.speed);
//            }
//        }else if(code == 83) {
//            //move back
//            System.out.println("back key pressed");
//            int x = g.carPanel.getX();
//            int y = g.carPanel.getY();
//            System.out.println("x,y \t" + x + "," + y);
//            if(y + g.speed <= 497){
//                g.carPanel.setLocation(x, y + g.speed);
//            }
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//}

public class CarHandler implements KeyListener {
    private CarGameGUI g;
    private boolean isMovingRight;
    private boolean isMovingLeft;
    private boolean isMovingUp;
    private boolean isMovingDown;

    public CarHandler(CarGameGUI ref) {
        this.g = ref;
        this.isMovingRight = false;
        this.isMovingLeft = false;
        this.isMovingUp = false;
        this.isMovingDown = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Không sử dụng trong trường hợp này
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case KeyEvent.VK_D:
            isMovingRight = true;
            break;
        case KeyEvent.VK_A:
            isMovingLeft = true;
            break;
        case KeyEvent.VK_W:
            isMovingUp = true;
            break;
        case KeyEvent.VK_S:
            isMovingDown = true;
            break;
        }
//        if (code == KeyEvent.VK_D) {
//            isMovingRight = true;
//        } else if (code == KeyEvent.VK_A) {
//            isMovingLeft = true;
//        } else if (code == KeyEvent.VK_W) {
//            isMovingUp = true;
//        } else if (code == KeyEvent.VK_S) {
//            isMovingDown = true;
//        }

        moveCar();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
        case KeyEvent.VK_D:
            isMovingRight = false;
            break;
        case KeyEvent.VK_A:
            isMovingLeft = false;
            break;
        case KeyEvent.VK_W:
            isMovingUp = false;
            break;
        case KeyEvent.VK_S:
            isMovingDown = false;
            break;
    }
//        if (code == KeyEvent.VK_D) {
//            isMovingRight = false;
//        } else if (code == KeyEvent.VK_A) {
//            isMovingLeft = false;
//        } else if (code == KeyEvent.VK_W) {
//            isMovingUp = false;
//        } else if (code == KeyEvent.VK_S) {
//            isMovingDown = false;
//        }
    }

    private void moveCar() {
        Thread moveThread = new Thread(() -> {
            while (isMovingRight || isMovingLeft || isMovingUp || isMovingDown) {
                int x = g.carPanel.getX();
                int y = g.carPanel.getY();

                if (isMovingRight) {
                    int width = g.fr.getWidth();
                    int carWidth = g.carPanel.getWidth();
                    if (x + g.speed <= width - carWidth - 140) {
                        g.carPanel.setLocation(x + g.speed, y);
                    }
                }
                if (isMovingLeft) {
                    if (x - g.speed >= 140) {
                        g.carPanel.setLocation(x - g.speed, y);
                    }
                }
                if (isMovingUp) {
                    if (y - g.speed >= 0) {
                        g.carPanel.setLocation(x, y - g.speed);
                    }
                }
                if (isMovingDown) {
                    if (y + g.speed <= 497) {
                        g.carPanel.setLocation(x, y + g.speed);
                    }
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        moveThread.start();
    }
    
}