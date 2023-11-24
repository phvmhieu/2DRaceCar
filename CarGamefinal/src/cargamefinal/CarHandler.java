/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cargamefinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author hieu
 */
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

    }

    private void moveCar() {
        Thread moveThread = new Thread(() -> {
            while (isMovingRight || isMovingLeft || isMovingUp || isMovingDown) {
                int x = g.carPanel.getX();
                int y = g.carPanel.getY();

                if (isMovingRight) {
                    int width = g.fr.getWidth();
                    int carWidth = g.carPanel.getWidth();
                    if (x + g.userSpeed <= width - carWidth - 140) {
                        g.carPanel.setLocation(x + g.userSpeed, y);
                    }
                }
                if (isMovingLeft) {
                    if (x - g.userSpeed >= 140) {
                        g.carPanel.setLocation(x - g.userSpeed, y);
                    }
                }
                if (isMovingUp) {
                    if (y - g.userSpeed >= 0) {
                        g.carPanel.setLocation(x, y - g.userSpeed);
                    }
                }
                if (isMovingDown) {
                    if (y + g.userSpeed <= g.background.getHeight() - g.carPanel.getHeight()) {
                        g.carPanel.setLocation(x, y + g.userSpeed);
                    }
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        moveThread.start();
    }
    
    
}


