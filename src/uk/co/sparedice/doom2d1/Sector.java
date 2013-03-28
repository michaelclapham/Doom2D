package uk.co.sparedice.doom2d1;

import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Michael
 * @author Fraser
 */
public class Sector {   
    
    //TODO: Make storage for Actors and tile layers within a sector
    private TileEngineGame game;
    private ArrayList<Actor> actors;
    private ArrayList<Layer> allLayers;
    private Layer bgLayer, platformLayer;
    private int sectorId = -1;

    
    public Sector(int sectorId, TileEngineGame game) {
        this.game = game;
        this.sectorId = sectorId;
        actors = new ArrayList<>();
        allLayers = new ArrayList<>(2);
    }
    
    public Sector(TileEngineGame game){
        this(0, game);
    }

    public void save(FileOutputStream out) {
    	for (Layer l : allLayers) {
    		l.save(out);
    	}
    }
    
    public TileEngineGame getGame() {
        return game;
    }
    
    public boolean addActor(Actor a){
        boolean success = actors.add(a);
        if(success){
            a.setCurrentSector(this);
        }
        return success;
    }
    
    public boolean removeActor(Actor a){
        boolean success = actors.remove(a);
        if(success){
            a.setCurrentSector(this);
        }
        return success;
    }
    
    public boolean removeActor(int i){
        if(i < actors.size()){
            actors.get(i).setCurrentSector(null);
            actors.remove(i);
            return true;
        } else {
            return false;
        }
    }
    
    public void addLayer(Layer l){
        allLayers.add(l);
        switch(l.getLayerType()){
            case Layer.TYPE_BG: bgLayer = l; break;
            case Layer.TYPE_PLATFORM: platformLayer = l; break;
        }
    }
    
    public ArrayList<Layer> getLayers(){
        return allLayers;
    }

    public Layer getBgLayer() {
        return bgLayer;
    }

    public Layer getPlatformLayer() {
        return platformLayer;
    }

    public int getSectorId() {
        return sectorId;
    }
    
}
