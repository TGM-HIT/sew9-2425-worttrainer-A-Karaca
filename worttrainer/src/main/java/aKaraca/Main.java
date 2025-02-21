package aKaraca;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {


    public static void main(String[] args) {
        //initial spellingTrainer
        SpellingTrainer spellingTrainer = new SpellingTrainer();
        String[] currentItem = new String[2];
        spellingTrainer.randomizeItem();
        try {
            currentItem = spellingTrainer.getCurrentItem();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Get Image from URL
        URL url;
        try {
            url = new URL(currentItem[1]);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        Image image;
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        image = image.getScaledInstance(600,300,Image.SCALE_DEFAULT);

        //Start of the Game
        String playerInput = "";
        playerInput = JOptionPane.showInputDialog(
                new ImageIcon(image),
                spellingTrainer.getStats());



        while(!playerInput.isEmpty()) {
            try {
                spellingTrainer.compareItem(playerInput);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            spellingTrainer.randomizeItem();
            try {
                currentItem = spellingTrainer.getCurrentItem();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            try {
                url = new URL(currentItem[1]);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            try {
                image = ImageIO.read(url);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            image = image.getScaledInstance(600,300,Image.SCALE_DEFAULT);
             playerInput = JOptionPane.showInputDialog(
                    new ImageIcon(image),
                     spellingTrainer.getStats() + "\nLetzte Eingabe war: " + spellingTrainer.getLastScoreChange());


        }
    }
}