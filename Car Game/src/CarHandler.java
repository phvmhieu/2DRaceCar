
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
public class CarHandler implements KeyListener{
    CarGameGUI g;
    public CarHandler (CarGameGUI ref){
        this.g = ref;
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //moving car by using this method
        //68 for right, 65 for left
        int code = e.getKeyCode();
        //System.out.println("Key pressed code:\t" + code);
        if(code == 68){
            //move right
            System.out.println("right key pressed");
            int x = g.carPanel.getX();
            int y = g.carPanel.getY();
            System.out.println("x,y \t" + x + "," + y);
            int width = g.fr.getWidth();
            int carWidth = g.carPanel.getWidth();
            if(x + g.speed <= width - carWidth - 140){
                g.carPanel.setLocation(x + g.speed, y);
            }
        }
        else if(code == 65){
            //move left
            System.out.println("left key pressed");
            int x = g.carPanel.getX();
            int y = g.carPanel.getY();
            System.out.println("x,y \t" + x + "," + y);
            if(x - g.speed >= 140){
                g.carPanel.setLocation(x - g.speed, y);
            }
        }else if(code == 87) {
            //move front
            System.out.println("front key pressed");
            int x = g.carPanel.getX();
            int y = g.carPanel.getY();
            System.out.println("x,y \t" + x + "," + y);
            if(y - g.speed >= 0){
                g.carPanel.setLocation(x, y - g.speed);
            }
        }else if(code == 83) {
            //move back
            System.out.println("back key pressed");
            int x = g.carPanel.getX();
            int y = g.carPanel.getY();
            System.out.println("x,y \t" + x + "," + y);
            if(y + g.speed <= 497){
                g.carPanel.setLocation(x, y + g.speed);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
