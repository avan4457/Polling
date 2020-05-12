package polling.Utils;



import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class QueryUtil {

	public static String queryById(String Id) throws SAXException, IOException, ParserConfigurationException {

		NodeList nl;
		Element elm = null;

		nl = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\OnlinePollingSystem\\WEB-INF\\ElectionQuery.xml")).getElementsByTagName(CommonConstants.TAG);
		
		for(int x = 0; x <nl.getLength(); x++){
			 elm = (Element)nl.item(x);
			 if(elm.getAttribute(CommonConstants.ATT_ID).equals("id"));
			 break;
		}
		return elm.getTextContent().trim();
		
	}

}