package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends  Entity {

    GamePanel gp ;
    KeyHandler keyH ;
    int countI = 0;
    int counter_For_CountI = 1;
    boolean isMirrored = false;


    public  Player(GamePanel gp , KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImages();

    }

    public void setDefaultValues(){
        x = 100 ;
        y = 100 ;
        speed = 3 ;
        sprint = 5 ;
        direction = "right";
        state = "sprinting";
    }


    public void getPlayerImages(){

        try{
            player = ImageIO.read(getClass().getResourceAsStream("/player/marche_face_nue.png"));
            player_Mirrored = ImageIO.read(getClass().getResourceAsStream("/player/marche_nue.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update(){
        if (direction.equals("left")){
            isMirrored = true;
        }else{
            isMirrored = false;
        }



        if(keyH.sprintPressed){
            if (keyH.upPressed) {
                y -= sprint;
                direction = "up";
            }
            if (keyH.downPressed) {
                y += sprint;
                direction = "down";
            }
            if (keyH.rightPressed) {
                x += sprint;
                direction = "right";
            }
            if (keyH.leftPressed) {
                x -= sprint;
                direction = "left";
            }
            state = "sprinting" ;
        } else {
            if (keyH.upPressed) {
                y -= speed;
                direction = "up";
                state = "walking";
            }
            if (keyH.downPressed) {
                y += speed;
                direction = "down";
                state = "walking";
            }
            if (keyH.rightPressed) {
                x += speed;
                direction = "right";
                state = "walking";
            }
            if (keyH.leftPressed) {
                x -= speed;
                direction = "left";
                state = "walking";
            }if (keyH.downReleased) {
                counter_For_CountI = 1;
            }if (keyH.upReleased) {
                counter_For_CountI = 1;
            }
        }
     /*   System.out.println(" spriteCounter: " + spritecounter
                + " spriteNumber: " + spriteNumber
                + " countI: " + countI
                +" counter_For_CountI: " + counter_For_CountI
        );*/

     /*  if(keyH.rightPressed == false
               && keyH.leftPressed == false
               && keyH.upPressed == false
               && keyH.downPressed == false) {
            state = "idle";
        }

      */






        spriteCounter(10);

    }


    public void spriteCounter(int count){
        spritecounter++;
        if (spritecounter > count) {
            if (spriteNumber == 1 ){
                spriteNumber = 2 ;
            } else if (spriteNumber == 2) {
                spriteNumber = 3;
            } else if (spriteNumber == 3) {
                spriteNumber = 4;
            } else if (spriteNumber == 4) {
                spriteNumber = 5;
            } else if (spriteNumber == 5) {
                spriteNumber = 6;
            } else if (spriteNumber == 6) {
                spriteNumber = 1;
            }
            spritecounter = 0;
        }
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    public BufferedImage PlayerWalking(BufferedImage image){
        switch (direction) {
            case "up" :
                if (spriteNumber == 1) {
                    image = player.getSubimage(258,193 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 2) {
                    image = player.getSubimage(387,193 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 3) {
                    image = player.getSubimage(258,193 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 4) {
                    image = player.getSubimage(387,193 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 5) {
                    image = player.getSubimage(258,193 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 6) {
                    image = player.getSubimage(387,193 , gp.tileSize , gp.tileSize);
                }
                break;
            case "down" :
                if (spriteNumber == 1) {
                    image = player.getSubimage(0,193 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 2) {
                    image = player.getSubimage(129,193 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 3) {
                    image = player.getSubimage(0,193 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 4) {
                    image = player.getSubimage(129,193 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 5) {
                    image = player.getSubimage(0,193 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 6) {
                    image = player.getSubimage(129,193 , gp.tileSize , gp.tileSize);
                }
                break;
            case "right" :
                if (spriteNumber == 1) {
                    image = player.getSubimage(0,255 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 2) {
                    image = player.getSubimage(64,255 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 3) {
                    image = player.getSubimage(129,255 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 4) {
                    image = player.getSubimage(193,255 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 5) {
                    image = player.getSubimage(257,255 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 6) {
                    image = player.getSubimage(321,255 , gp.tileSize , gp.tileSize);
                }
                break;
            case "left" :

                if (spriteNumber == 1) {
                    image = player_Mirrored.getSubimage(960,255 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 2) {
                    image = player_Mirrored.getSubimage(896,255 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 3) {
                    image = player_Mirrored.getSubimage(832,255 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 4) {
                    image = player_Mirrored.getSubimage(768,255 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 5) {
                    image = player_Mirrored.getSubimage(704,255 , gp.tileSize , gp.tileSize);
                }
                if (spriteNumber == 6) {
                    image = player_Mirrored.getSubimage(640,255 , gp.tileSize , gp.tileSize);
                }
                break;
        }
        return image;
    }
    public BufferedImage PlayerIdle(BufferedImage image){
        switch (direction) {
            case "right" :
                if (spriteNumber >= 1 && spriteNumber <= 6  ) {
                    image = player.getSubimage(0,895 , gp.tileSize , gp.tileSize);
                }
                break;
            case "left" :
                if (spriteNumber >= 1 && spriteNumber <= 6  ) {
                    image = player_Mirrored.getSubimage(960,895 , gp.tileSize , gp.tileSize);
                }
                break;
            case "up" :
                if (spriteNumber >= 1 && spriteNumber <= 6  ) {
                    image = player.getSubimage(0,65 , gp.tileSize , gp.tileSize);
                }
                break;
            case "down" :
                if (spriteNumber >= 1 && spriteNumber <= 6  ) {
                    image = player.getSubimage(0,0 , gp.tileSize , gp.tileSize);
                }
                break;
        }
        return image;
    }

    public BufferedImage PlayerRunning(BufferedImage image){
        switch (direction){
            case  "up" :
                switch (countI) {
                    case 0:
                        if (spriteNumber == 1) {
                            image = player_Mirrored.getSubimage(512, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 2) {
                            image = player_Mirrored.getSubimage(704, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 3) {
                            image = player.getSubimage(448, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 4) {
                            image = player.getSubimage(256, 193 , gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 5) {
                            image = player_Mirrored.getSubimage(512, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 6) {
                            image = player_Mirrored.getSubimage(704, 193, gp.tileSize, gp.tileSize);
                            counter_For_CountI++;
                            if(counter_For_CountI >= 12){
                                countI++;
                                counter_For_CountI = 1;
                            }
                        }
                        break;
                    case 1:
                        if (spriteNumber == 1) {
                            image = player.getSubimage(448, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 2) {
                            image = player.getSubimage(256, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 3) {
                            image = player_Mirrored.getSubimage(512, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 4) {
                            image = player_Mirrored.getSubimage(704,193 , gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 5) {
                            image = player.getSubimage(448, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 6) {
                            image = player.getSubimage(256, 193, gp.tileSize, gp.tileSize);
                            counter_For_CountI++;
                            if(counter_For_CountI >= 12){
                                countI--;
                                counter_For_CountI = 1;
                            }
                        }
                        break;
                }
                break;
            case  "down" :
                switch (countI) {
                    case 0:
                        if (spriteNumber == 1) {
                            image = player_Mirrored.getSubimage(768, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 2) {
                            image = player_Mirrored.getSubimage(960, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 3) {
                            image = player.getSubimage(192, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 4) {
                            image = player.getSubimage(0, 193 , gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 5) {
                            image = player_Mirrored.getSubimage(768, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 6) {
                            image = player_Mirrored.getSubimage(960, 193, gp.tileSize, gp.tileSize);
                            counter_For_CountI++;
                            if(counter_For_CountI >= 12){
                                countI++;
                                counter_For_CountI = 1;
                            }


                        }
                        break;
                    case 1:
                        if (spriteNumber == 1) {
                            image = player.getSubimage(192, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 2) {
                            image = player.getSubimage(0, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 3) {
                            image = player_Mirrored.getSubimage(768, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 4) {
                            image = player_Mirrored.getSubimage(960,193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 5) {
                            image = player.getSubimage(192, 193, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 6) {
                            image = player.getSubimage(0, 193, gp.tileSize, gp.tileSize);
                            counter_For_CountI++;
                            if(counter_For_CountI >= 12){
                                countI--;
                                counter_For_CountI = 1;
                            }

                        }
                        break;
                }
                break;
          case  "right" :
              switch (countI) {
                  case 0:
                      if (spriteNumber == 1) {
                          image = player.getSubimage(192, 255, gp.tileSize, gp.tileSize);
                      }
                      if (spriteNumber == 2) {
                          image = player.getSubimage(384, 255, gp.tileSize, gp.tileSize);
                      }
                      if (spriteNumber == 3) {
                          image = player.getSubimage(320, 255, gp.tileSize, gp.tileSize);
                      }
                      if (spriteNumber == 4) {
                          image = player.getSubimage(448, 255 , gp.tileSize, gp.tileSize);
                      }
                      if (spriteNumber == 5) {
                          image = player.getSubimage(192, 255, gp.tileSize, gp.tileSize);
                      }
                      if (spriteNumber == 6) {
                          image = player.getSubimage(384, 255, gp.tileSize, gp.tileSize);

                          countI++;
                      }
                      break;
                  case 1:
                      if (spriteNumber == 1) {
                          image = player.getSubimage(320, 255, gp.tileSize, gp.tileSize);
                      }
                      if (spriteNumber == 2) {
                          image = player.getSubimage(448, 255, gp.tileSize, gp.tileSize);
                      }
                      if (spriteNumber == 3) {
                          image = player.getSubimage(192, 255, gp.tileSize, gp.tileSize);
                      }
                      if (spriteNumber == 4) {
                          image = player.getSubimage(384,255 , gp.tileSize, gp.tileSize);
                      }
                      if (spriteNumber == 5) {
                          image = player.getSubimage(320, 255, gp.tileSize, gp.tileSize);
                      }
                      if (spriteNumber == 6) {
                          image = player.getSubimage(448, 255, gp.tileSize, gp.tileSize);
                          countI--;
                      }
                      break;
              }
              break;
            case  "left" :
                switch (countI) {
                    case 0:
                        if (spriteNumber == 1) {
                            image = player_Mirrored.getSubimage(832, 255, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 2) {
                            image = player_Mirrored.getSubimage(576, 255, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 3) {
                            image = player_Mirrored.getSubimage(640, 255, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 4) {
                            image = player_Mirrored.getSubimage(512, 255 , gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 5) {
                            image = player_Mirrored.getSubimage(832, 255, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 6) {
                            image = player_Mirrored.getSubimage(576, 255, gp.tileSize, gp.tileSize);
                            countI++;
                        }
                        break;
                    case 1:
                        if (spriteNumber == 1) {
                            image = player_Mirrored.getSubimage(640, 255, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 2) {
                            image = player_Mirrored.getSubimage(512, 255, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 3) {
                            image = player_Mirrored.getSubimage(832, 255, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 4) {
                            image = player_Mirrored.getSubimage(576,255, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 5) {
                            image = player_Mirrored.getSubimage(640, 255, gp.tileSize, gp.tileSize);
                        }
                        if (spriteNumber == 6) {
                            image = player_Mirrored.getSubimage(512, 255, gp.tileSize, gp.tileSize);
                            countI--;
                        }
                        break;
                }
                break;
        }
        return image;
    }



    public void paint(Graphics2D g){


        BufferedImage image = null ;

        switch (state){
            case "sprinting" :
                image =  PlayerRunning(image); break ;
            case "walking" :
                image =  PlayerWalking(image); break;
            case "idle" :
                image =  PlayerIdle(image); break;
            case "interact" :

        }

        if(image != null){
                g.drawImage(resize(image , gp.tileSize * 2, gp.tileSize * 2) , x , y , null);
        }


    }
}
