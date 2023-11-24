/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cargamefinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.random;
import java.lang.System.Logger;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hieu
 */

class common {
    int score = 0;
}

public class Obstacle1 extends RandomLocation implements Runnable {
    private JPanel blockPanel;
    private int obstacleSpeed;
    private JLabel background;
    private Random random;
    private common Score;
    private Points point;
    CarGameGUI g;
    
    public Obstacle1(CarGameGUI g, JPanel blockPanel, int obstacleSpeed, JLabel background, common Score, Points point) {
        this.blockPanel = blockPanel;
        this.obstacleSpeed = obstacleSpeed;
        this.background = background;
        this.random = new Random();
        this.Score = Score;
        this.point = point;
        this.g = g;

    }

    @Override
    public void run() {
        
        randomLocation(g, blockPanel, obstacleSpeed, background, Score, point);
    }
}

class Obstacle2 extends RandomLocation implements Runnable {
    private JPanel blockPanel;
    private int obstacleSpeed;
    private JLabel background;
    private Random random;
    private common Score;
    private Points point;

    CarGameGUI g;

    public Obstacle2(CarGameGUI g, JPanel blockPanel, int obstacleSpeed, JLabel background, common Score, Points point) {
        this.blockPanel = blockPanel;
        this.obstacleSpeed = obstacleSpeed;
        this.background = background;
        this.random = new Random();
        this.Score = Score;
        this.point = point;
        this.g = g;
    }

    @Override
    public void run() {
        
        randomLocation(g, blockPanel, obstacleSpeed, background, Score, point);
    }
}

class Obstacle3 extends RandomLocation implements Runnable {
    private JPanel blockPanel;
    private int obstacleSpeed;
    private JLabel background;
    private Random random;
    private common Score;
    private Points point;
    CarGameGUI g;
    
    public Obstacle3(CarGameGUI g, JPanel blockPanel, int obstacleSpeed, JLabel background, common Score, Points point) {
        this.blockPanel = blockPanel;
        this.obstacleSpeed = obstacleSpeed;
        this.background = background;
        this.random = new Random();
        this.Score = Score;
        this.point = point;
        this.g = g;

    }

    @Override
    public void run() {
        
        randomLocation(g, blockPanel, obstacleSpeed, background, Score, point);
    }
    
}


