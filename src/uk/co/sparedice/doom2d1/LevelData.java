
package uk.co.sparedice.doom2d1;

import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class LevelData {
    
    private ArrayList<Sector> allSectors;
    private ArrayList<Sector> visibleSectors;
    
    public void addSector(Sector s){
        allSectors.add(s);
    }
    
    public void makeVisible(Sector s){
        visibleSectors.add(s);
    }
    
    public void makeVisible(int sectorId){
        for(int i = 0; i < allSectors.size(); i++){
            if(allSectors.get(i).getSectorId() == sectorId){
                visibleSectors.add(allSectors.get(i));
            }
        }
    }

    public ArrayList<Sector> getAllSectors() {
        return allSectors;
    }

    public void setVisibleSectors(ArrayList<Sector> visibleSectors) {
        this.visibleSectors = visibleSectors;
    }
    
    
    

}
