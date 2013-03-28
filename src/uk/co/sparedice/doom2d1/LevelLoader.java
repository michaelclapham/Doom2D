
package uk.co.sparedice.doom2d1;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Michael
 * @author Fraser
 */
public class LevelLoader {
    
    /*
     * Loads level by its filename.
     */
    public static LevelData loadLevel(String levelName, TileEngineGame game){
        //TODO: Implement code to load tile data and initial game objects. (FRASER)
    	LevelData data = new LevelData();
    	
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse("maps/" + levelName + ".xml");
			Element docEle = dom.getDocumentElement();
			int width = getIntValue(docEle, "width"), height = getIntValue(docEle, "height");
			NodeList sectorList = docEle.getElementsByTagName("sector");
			if (sectorList != null && sectorList.getLength() > 0) {
				FileInputStream in = new FileInputStream("maps/" + levelName + ".map");
				for (int i = 0; i < sectorList.getLength(); i++) {
					Element el = (Element) sectorList.item(i);
					int id = Integer.parseInt(el.getFirstChild().getNodeValue());
					Sector s = new Sector(id, game);
					NodeList layerList = el.getElementsByTagName("layer");
					if (layerList != null && layerList.getLength() > 0) {
						for (int j = 0; j < layerList.getLength(); j++) {
							Element el2 = (Element) layerList.item(i);
							int type = Integer.parseInt(el2.getFirstChild().getNodeValue());
							s.addLayer(new Layer(width, height, type, in));							
						}
					}
					data.addSector(s);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

        return data;
    }
    
    private static String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}

	private static int getIntValue(Element ele, String tagName) {
		return Integer.parseInt(getTextValue(ele, tagName));
	}

}
