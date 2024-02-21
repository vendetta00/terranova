package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends  Entity {


    GamePanel gp ;
    KeyHandler keyH ;


    public  Player(GamePanel gp , KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
    }

    public void setDefaultValues(){

        x = 100 ;
        y = 100 ;
        speed = 4 ;
        sprint = 8 ;

    }




    public void update(){

   if(keyH.sprintPressed){
       if (keyH.upPressed) {
           y -= sprint;
       }
       if (keyH.downPressed) {
           y += sprint;
       }
       if (keyH.rightPressed) {
           x += sprint;
       }
       if (keyH.leftPressed) {
           x -= sprint;
       }
   } else {
       if (keyH.upPressed) {
           y -= speed;
       }
       if (keyH.downPressed) {
           y += speed;
       }
       if (keyH.rightPressed) {
           x += speed;
       }
       if (keyH.leftPressed) {
           x -= speed;
       }
   }



    }



    public void paint(Graphics2D g){

        g.setColor(Color.white);
        g.fillRect(x , y ,  gp.tileSize , gp.tileSize);

    }



}
