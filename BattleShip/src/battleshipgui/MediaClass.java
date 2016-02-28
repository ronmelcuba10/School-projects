////////////////////////////////////////////////////////////////////////////////

// Title:            Battleship
// Files:            (list of source files)
// Semester:         COP3337 Fall 2015
//
// Author:           1657691
// Lecturer's Name:  Cristy Charters
//
// Battleship game
//
////////////////////////////////////////////////////////////////////////////////


package battleshipgui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.Random;

/**
 *
 * @author
 */
public class MediaClass {

    AudioClip Explosion1, Explosion2, Explosion3, Explosion4, Explosion5, Explosion6,
            Missshot1, Missshot2, Missshot3, Missshot4, Missshot5, Background, Complaint1,
            Complaint2, Mock1, IllbeBack, HastalaVis, Maythe4th;

    /**
     *
     */
    public MediaClass() {
        Explosion1 = Applet.newAudioClip(getClass().getResource("/sounds/explosion0.wav"));
        Explosion2 = Applet.newAudioClip(getClass().getResource("/sounds/explosion1.wav"));
        Explosion3 = Applet.newAudioClip(getClass().getResource("/sounds/explosion2.wav"));
        Explosion4 = Applet.newAudioClip(getClass().getResource("/sounds/explosion3.wav"));
        Explosion5 = Applet.newAudioClip(getClass().getResource("/sounds/explosion4.wav"));
        Explosion6 = Applet.newAudioClip(getClass().getResource("/sounds/explosion1.wav"));
        Missshot1 = Applet.newAudioClip(getClass().getResource("/sounds/missshot0.wav"));
        Missshot2 = Applet.newAudioClip(getClass().getResource("/sounds/missshot1.wav"));
        Missshot3 = Applet.newAudioClip(getClass().getResource("/sounds/missshot2.wav"));
        Missshot4 = Applet.newAudioClip(getClass().getResource("/sounds/missshot3.wav"));
        Missshot5 = Applet.newAudioClip(getClass().getResource("/sounds/missshot4.wav"));
        Background = Applet.newAudioClip(getClass().getResource("/sounds/back1.wav"));
        Complaint1 = Applet.newAudioClip(getClass().getResource("/sounds/complaint1.wav"));
        Complaint2 = Applet.newAudioClip(getClass().getResource("/sounds/complaint2.wav"));
        Mock1      = Applet.newAudioClip(getClass().getResource("/sounds/mock1.wav"));
        IllbeBack = Applet.newAudioClip(getClass().getResource("/sounds/illbeback.wav"));
        HastalaVis = Applet.newAudioClip(getClass().getResource("/sounds/hastalavis.wav"));
        Maythe4th  = Applet.newAudioClip(getClass().getResource("/sounds/maythe4th.wav"));
    }

    /**
     * plays background
     */
    public void playBack() {
        Background.play();
    }
    
    /**
     * plays a laugh
     */
    public void playmock() {
        Mock1.play();
    }
    
    /**
     * plays Ill be back
     */
    public void playIllbb() {
        IllbeBack.play();
    }
    
    /**
     * plays Hasta la vista baby
     */
    public void playHlvb() {
        HastalaVis.play();
    }
    
    /**
     * plays a May the force b with you
     */
    public void playMt4th() {
        Maythe4th.play();
    }
    /**
     * plays a random complaint
     */
    public void playComplaint() {
        Random rnd = new Random();
        switch (rnd.nextInt(2)) {
            case 0:
                Complaint1.play();
                break;
            case 1:
                Complaint2.play();
                break;
        }
    }

    /**
     *plays a random explosion
     */
    public void playExplosion() {
        Random rnd = new Random();
        switch (rnd.nextInt(6)) {
            case 0:
                Explosion1.play();
                break;
            case 1:
                Explosion2.play();
                break;
            case 2:
                Explosion3.play();
                break;
            case 3:
                Explosion4.play();
                break;
            case 4:
                Explosion5.play();
                break;
            case 5:
                Explosion6.play();
                break;
        }
    }

    /**
     * plays a random miss shot
     */
    public void playMissShot() {
        Random rnd = new Random();
        switch (rnd.nextInt(5)) {
            case 0:
                Missshot1.play();
                break;
            case 1:
                Missshot2.play();
                break;
            case 2:
                Missshot3.play();
                break;
            case 3:
                Missshot4.play();
                break;
            case 4:
                Missshot5.play();
                break;

        }
    }

}
