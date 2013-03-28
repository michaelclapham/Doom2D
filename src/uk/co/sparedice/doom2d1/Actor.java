
package uk.co.sparedice.doom2d1;

/**
 *
 * @author Michael
 */
public class Actor extends Updatable {

    private Sector currentSector; 
    
    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }  
    
    public void setCurrentSector(Sector s){
        this.currentSector = s;
        setGame(s.getGame());
    }

}
