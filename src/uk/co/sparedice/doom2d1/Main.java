/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.sparedice.doom2d1;

import org.newdawn.slick.SlickException;

/**
 *
 * @author Michael
 */
public class Main { 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Game2.main(args);
            //net.fraserelliott.doom2d.Game.main(args);
        } catch (SlickException ex) {
            //
        }
    }
}
