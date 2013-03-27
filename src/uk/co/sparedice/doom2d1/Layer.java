
package uk.co.sparedice.doom2d1;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * A Layer of tiles which represents a part of the game environment.
 * A group of tiles in the game world where the tiles within a given layer do 
 * not overlap each other.
 * @author Michael Clapham
 */
public class Layer {
    
    private int[][] tileData; //Stores tiles type id
    private int width = 0; //Number of tiles wide
    private int height = 0; //Number of tiles high
    
    //Type constants
    public static final int TYPE_BG = 0;
    public static final int TYPE_PLATFORM = 1;
    public static final int TYPE_CUSTOM = 2;
    
    //Type of layer
    private int layerType = TYPE_BG;

    public Layer(int width, int height, int type) {
        this.width = width;
        this.height = height;
        this.layerType = type;
        tileData = new int[width][height];
    }
    
    /* Sets the initial tile data */
    public void setTileData(int[][] tileData) {
        this.tileData = tileData;
        this.width = tileData.length;
        if(width > 0){
            this.height = tileData[0].length;
        } else {
            this.height = 0;
        }
    }
    
    /**
     * Gets the type id of a tile at a given position in a layer.
     * @param x The position of the tile within the layer horizontally
     * @param y The position of the tile within the layer vertically
     * @return
     */
    public int getTileAt(int x, int y){
        return tileData[x][y];
        //TODO: Add error checking to make sure tile position is in range
    }
    
    
    public void setTileAt(int x, int y, int type){
        tileData[x][y] = type;
        //TODO: Add error checking to make sure tile position and type is in range
    }
    
    public void setTileAt(int x, int y, int type, boolean expand){
        if( expand ){
            if(x > width){
                //TODO: Make array expand if position is out of current range. Low Priority
            }
        } else {
            setTileAt(x, y, type);
        }
        throw new NotImplementedException();
    }

    public int getLayerType() {
        return layerType;
    }

}
