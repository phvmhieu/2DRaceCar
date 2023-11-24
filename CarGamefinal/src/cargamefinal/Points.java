/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cargamefinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author hieu
 */
public class Points extends JPanel{
    private int point = 0;

    
    public void setPoint(int point){
        this.point = point;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        // ve khung hinh chu nhat
        int width = 100;
        int height = 80;
        g.drawRect(0, 0, width, height);
        g.fillRect(0, 0, width, height);
        // ve diem
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + point, 15, height / 2 - 16 / 2);
    }
}
