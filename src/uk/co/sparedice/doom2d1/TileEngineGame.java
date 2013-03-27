
package uk.co.sparedice.doom2d1;

import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Michael
 */
public class TileEngineGame extends BasicGame {

    /* Stores Window width and height in pixels */
    public int currentWindowWidth, currentWindowHeight;
    
    /* Stores tile data */
    public int[][] tileData;
    
    /* Stores images for tileset */
    public ArrayList<Image> tileSet;
    
    public static void main(String[] args) throws SlickException {
        startGame(new TileEngineGame());
    }
    
    /* Starts the execution of a given instance of a TileEngineGame */
    public static void startGame(TileEngineGame tgame) throws SlickException{
        AppGameContainer app = new AppGameContainer(tgame);
        
        app.setDisplayMode(tgame.getCurrentWindowWidth(), tgame.getCurrentWindowHeight(), false);
        app.start();
    }
    
    public TileEngineGame() {
        super("TileEngineGame");
        tileSet = new ArrayList<Image>();
        currentWindowWidth = 800;
        currentWindowHeight = 480;
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        //
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        //
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        //
    }

    public int getCurrentWindowWidth() {
        return currentWindowWidth;
    }

    public void setCurrentWindowWidth(int currentWindowWidth) {
        this.currentWindowWidth = currentWindowWidth;
    }

    public int getCurrentWindowHeight() {
        return currentWindowHeight;
    }

    public void setCurrentWindowHeight(int currentWindowHeight) {
        this.currentWindowHeight = currentWindowHeight;
    }
    
    

}
