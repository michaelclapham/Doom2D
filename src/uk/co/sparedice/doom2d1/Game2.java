/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.sparedice.doom2d1;

import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Michael
 */
public class Game2 extends BasicGame implements MouseListener {
    
    private Image[] images;
    private int[][] tileMap;
    private int mapWidth = 20;
    private int mapHeight = 20;
    private int tileWidth = 40;
    private int tileHeight = 40;
    private boolean renderNeeded = true;
    private int tileOffsetX = 0;
    private int tileOffsetY = 0;
    private Image imageBob;
    private SquareParticleEffect spt;
    private ArrayList<SquareParticleEffect> spl = new ArrayList<SquareParticleEffect>();

    public Game2() {
        super("Michael Test Game");
    }
    
    @Override
    public void init(GameContainer gc) throws SlickException {
        /* Load images array */
        images = new Image[5];
        images[0] = new Image("img/grass3.png");
        images[1] = new Image("img/stone3.png");
        imageBob = new Image("img/Tile_Drawings1-06.png");
        images[2] = new Image("img/Tile_Drawings1-07.png");
        images[3] = new Image("img/Tile_Drawings1-08.png");
        images[4] = new Image("img/Tile_Drawings1-09.png");
        tileWidth = images[0].getWidth();
        tileHeight = images[1].getHeight();
        spt = new SquareParticleEffect(200, 300, 4, 10);
        gc.setTargetFrameRate(30);
    }

    @Override
    public void update(GameContainer gc, int f) throws SlickException {
        spt.update();
        for(int i = 0; i < spl.size(); i++){
            spl.get(i).update();
            if(spl.get(i).life > 300){
                spl.remove(i);
            }
        }
    }

    @Override
    public void render(GameContainer gc, Graphics gr) throws SlickException {
        if(renderNeeded){
            for(int i = 0; i < mapWidth; i++){
                for(int j = 0; j < mapHeight; j++){
                    gr.drawImage(images[data[j][i]], i*tileWidth + tileOffsetX, j*tileHeight + tileOffsetY);
                }
            }
            gr.drawImage(imageBob, 0, 0);
            spt.render(gr);
            for(int i = 0; i < spl.size(); i++){
                spl.get(i).render(gr);
            }
            renderNeeded = true;
        }
    }

    int[][] data = { 
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, },
    { 1, 0, 0, 0, 0, 0, 2, 3, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
    { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, } };
    
    public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Game2());

		app.setDisplayMode(800, 600, false);
		app.start();
    }

    @Override
    public void mouseReleased(int button, int x, int y) {
        if(data[(int)(y/tileWidth)][(int)(x/tileHeight)] != 0){
            data[(int)(y/tileWidth)][(int)(x/tileHeight)] = 0;
            spl.add(new SquareParticleEffect(x,y,7,6));
        }
    }
    
    
}
