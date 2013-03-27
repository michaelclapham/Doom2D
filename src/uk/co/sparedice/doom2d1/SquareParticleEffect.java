/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.sparedice.doom2d1;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Michael
 */
public class SquareParticleEffect {
    
    private int sections = 4;
    private int sectionWidth = 10;
    private ArrayList<SquareParticle> particles;
    public int life = 0;

    public SquareParticleEffect(int x, int y, int sections, int sectionWidth) {
        this.sections = sections;
        this.sectionWidth = sectionWidth;
        particles = new ArrayList<SquareParticle>(sections*sections);
        for(int i = 0; i < sections; i++){
            for(int j = 0; j < sections; j++){
                particles.add(new SquareParticle(x + i*sectionWidth, y + j*sectionWidth, (Math.random()*180)-90));
            }
        }
    }
    
    public void render(Graphics gr){
        for(int i = 0; i < particles.size(); i++){
            SquareParticle sp = particles.get(i);
            gr.setColor(Color.darkGray);
            gr.fillRect(sp.posX, sp.posY, sectionWidth, sectionWidth);
        }
    }
    
    public void update(){
        for(int i = 0; i < particles.size(); i++){
            particles.get(i).update();
        }
        life++;
    }
    
    private static class SquareParticle {

        public float posX, posY, velX, velY, accX, accY;
        
        public SquareParticle(float x, float y, double angle) {
            posX = x;
            posY = y;
            accX += 6 * Math.sin(angle);
            accY += 6 * Math.cos(angle);
        }
        
        public void update(){
            //Gravity
            accY += 0.4f;
            
            //Air resistance
            accX -= 0.03*velX;
            accY -= 0.01*velY;
            
            //Physics calculations
            posX += velX;
            posY += velY;
            velX += accX;
            velY += accY;
            accX = 0;
            accY = 0;
        }
    }
    
}
