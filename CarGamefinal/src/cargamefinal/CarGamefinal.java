package cargamefinal;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class CarGamefinal {
    JFrame fr;
    JPanel startPanel;
    JPanel closePanel;
    JLabel homePage;
    JButton openGame;
    JButton closeGame;
    int width;
    int height;
    public CarGamefinal(){
        width = 1000;
        height = 417;
        initGUI();
    }
    private void initGUI(){
        fr = new JFrame("HOME");
        homePage = new JLabel("", new ImageIcon("images/home-page.png"), JLabel.CENTER);
        homePage.setBounds(0, 0, width, height);
        fr.add(homePage);
        Color BG = Color.decode("#EFBB00");
        openGame = new JButton("START GAME");
        openGame.setBackground(BG);
        closeGame = new JButton("CLOSE GAME");
        closeGame.setBackground(BG);
        Border border = new LineBorder(Color.black, 5);
        Font font = new Font("Sports World", Font.BOLD, 30);
        openGame.setBorder(border);
        openGame.setForeground(Color.red);
        openGame.setFont(font);
        closeGame.setBorder(border);
        closeGame.setForeground(Color.red);
        closeGame.setFont(font);
        openGame.addActionListener(e -> {
            try {
                try {
                    CarGameGUI cargamegui = new CarGameGUI(fr);
                } catch (IOException ex) {
                    Logger.getLogger(CarGamefinal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(CarGamefinal.class.getName()).log(Level.SEVERE, null, ex);
            }
            fr.setVisible(false);
        });
        closeGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            System.exit(0);
            }
        });
        
        startPanel = new JPanel();
        startPanel.add(openGame);
        startPanel.setBackground(BG);
        startPanel.setSize(250, 50);
        startPanel.setLocation(width / 2 - startPanel.getWidth(), height / 2 - startPanel.getHeight());
        homePage.add(startPanel);
        
        closePanel = new JPanel();
        closePanel.add(closeGame);
        closePanel.setBackground(BG);
        closePanel.setSize(250, 50);
        closePanel.setLocation(width / 2 - startPanel.getWidth(), height / 2 - startPanel.getHeight() + 70);
        homePage.add(closePanel);
        
        fr.setLayout(null);
        fr.setSize(1000, 450);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarGamefinal homeframe = new CarGamefinal();
        });
    }
}