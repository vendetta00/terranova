package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed , downPressed , leftPressed , rightPressed , sprintPressed, interactPressed, inventoryPressed;
    public boolean upReleased , downReleased , leftReleased , rightReleased, sprintReleased;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        switch (code) {
            case  KeyEvent.VK_Q:
                leftPressed = true; break;
            case  KeyEvent.VK_D:
                rightPressed = true; break;
            case  KeyEvent.VK_Z:
                upPressed = true; break;
            case  KeyEvent.VK_S:
                downPressed = true; break;
            case  KeyEvent.VK_TAB:
                inventoryPressed = true; break;
            case  KeyEvent.VK_SHIFT:
                sprintPressed = true; break;
            case  KeyEvent.VK_E:
                interactPressed = true; break;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        switch (code) {
            case  KeyEvent.VK_Q:
                leftPressed = false;
                 break;
            case  KeyEvent.VK_D:
                rightPressed = false; break;
            case  KeyEvent.VK_Z:
                upPressed = false; break;
            case  KeyEvent.VK_S:
                downPressed = false; break;

            case  KeyEvent.VK_TAB:
                inventoryPressed = false; break;
            case  KeyEvent.VK_SHIFT:
                sprintPressed = false; break;
            case  KeyEvent.VK_E:
                interactPressed = false; break;

        }



    }
}
