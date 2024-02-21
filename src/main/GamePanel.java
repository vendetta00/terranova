package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale  = 3  ;
    public int tileSize = originalTileSize * scale ; //48*48
    final int maxScreenCol = 40 ; //1920
    final int maxScreenRow = 22 ; //1080
    final int screenWidth = tileSize * maxScreenCol ;
    final int screenheight = tileSize * maxScreenRow ;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread ;


    Player player = new Player(this, keyH);


    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth , screenheight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }


     public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();

     }


    @Override
    public void run() {

        long lastLoopTime = System.nanoTime();
        final double TARGET_FPS = 60.0;
        final double OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        double lastFpsTime = 0;



        while (gameThread != null){

            long now = System.nanoTime();
            double updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);

            // on update le jeu dans le thread
            update();

            // on repaint le jeu dans le thread
            repaint();

            // Calculate FPS
            double currentFPS = 1000000000 / (System.nanoTime() - lastFpsTime);
            lastFpsTime = System.nanoTime();
            //System.out.println("FPS: " + currentFPS);
            try {
                Thread.sleep((long) ((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public  void update(){

        player.update();


    }

    public  void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g ;

        player.paint(g2);

        g2.dispose();

    }




}
