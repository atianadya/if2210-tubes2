package monopoliswing;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.*;
 
public class readxmlfile {

	private List<Integer> idarr = new ArrayList<Integer>();
	private List<String> effsarr = new ArrayList<String>();

	public void readXML() {
	    try {

	    	//getting xml file
	 		File fXmlFile = new File("cards.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		 
			//doc.getDocumentElement().normalize(); ???
		 
		 	//inserting card IDs and Effects into arrays
			NodeList nList = doc.getElementsByTagName("card");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					int id = Integer.parseInt(eElement.getAttribute("id"));
					String effect = eElement.getElementsByTagName("effect").item(0).getTextContent();
					idarr.add(id);
					effsarr.add(effect);
				}
			}
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	  }

	//returning array size
	public int getSize() {
		return idarr.size();
	}

	//returning single ID
	public int getID(int ID) {
		return idarr.get(ID-1);
	}

	//returning description of a card of particular ID
	public String getEff(int ID) {
		return effsarr.get(ID-1);
	}
}