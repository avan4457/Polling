package polling.Utils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import polling.Utils.CommonConstants;

public class QueryUtil {

	public static String queryByID(String id) throws SAXException, IOException, ParserConfigurationException {

		NodeList nodeList;
		Element element = null;
		/*
		 * Read the EmployeeQuery.xml file and read each query node into node
		 * list. It refers tag name query
		 */
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\Project\\WEB-INF\\Query.xml"))
				.getElementsByTagName(CommonConstants.Tag_Name);
		/*
		 * Extract the node from node list using query id query id is taken from
		 * query node attribute
		 */

		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);
			if (element.getAttribute(CommonConstants.Attr_Id).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}

	public static String queryById(String Id) throws SAXException, IOException, ParserConfigurationException {

		NodeList nl;
		Element elm = null;

		nl = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File(System.getProperty("catalina.base")
						+ "\\wtpwebapps\\OnlinePollingSystem\\WEB-INF\\ElectionQuery.xml"))
				.getElementsByTagName(CommonConstants.TAG);

		for (int x = 0; x < nl.getLength(); x++) {
			elm = (Element) nl.item(x);
			if (elm.getAttribute(CommonConstants.ATT_ID).equals("id"))
				;
			break;
		}
		return elm.getTextContent().trim();

	}

}