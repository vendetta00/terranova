package main;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        JFrame windows = new JFrame();
        windows.setTitle("TerraNova");
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setResizable(false);

        GamePanel gamePanel = new GamePanel();

        windows.add(gamePanel);

        windows.setLocationRelativeTo(null);
        windows.setVisible(true);

        windows.pack();

        gamePanel.startGameThread();




        }
    }
