package com.uwec.gradiance.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundNotification {

    public static void playSound() {
        
        String soundFilePath = "/Users/mitchdorbor/Documents/GitHub/gradiance/intelliJ projects/gradiance/src/main/resources/QueueTestSound.wav";

        try {
            File soundFile = new File(soundFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            //plays sound
            clip.start(); 

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
