
package uk.co.sparedice.doom2d1;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Michael
 */
public abstract class Updatable {
    
    public TileEngineGame game;
    public Rectangle touchRect = null;
    public boolean autoTouchable = true;
    public boolean autoDrawable = true;
    public boolean currentlyTracked = false;
    
    public void setGame(TileEngineGame game){
        this.game = game;
    }
    
    public void onAdded(TileEngineGame game){
        //Overridden
    }
    
    public Updatable(){
        //
    }

    public Updatable(TileEngineGame game) {
        this.game = game;
    }
    
    public abstract void update();

    public void draw(Graphics c){
        //
    }
    
    public void onTouchEvent(float touchX, float touchY){
        //Overridden
    }
    
    public void onTouchThis(float touchX, float touchY){
        //Overridden
    }
    
    public void onPress(float touchX, float touchY){
        //Overridden
    }

    public void onRemoved() {
        //
    }
}