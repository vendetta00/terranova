import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale  = 3 ;
    final int tileSize = originalTileSize * scale ; //48*48
    final int maxScreenCol = 40 ; //1920
    final int maxScreenRow = 22 ; //1080
    final int screenWidth = tileSize * maxScreenCol ;
    final int screenheight = tileSize * maxScreenRow ;

    Thread gameThread ;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth , screenheight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);



    }


     public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();

     }


    @Override
    public void run() {

        while (gameThread != null){

            // on update le jeu dans le thread
            update();

            // on repaint le jeu dans le thread
            repaint();
        }


    }

    public  void update(){

    }

    public  void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g ;

        g2.setColor(Color.white);

        g2.fillRect(100 , 100 ,  tileSize, tileSize);

    }




}
