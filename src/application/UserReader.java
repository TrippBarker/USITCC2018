package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UserReader {
	
	public ArrayList<User> readXML() {
		ArrayList<User> users = new ArrayList<User>();
		File xmlFile = new File("users.xml");
		Document doc = null;
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlFile);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
		NodeList list = doc.getElementsByTagName("user");
		User user;
		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i).getChildNodes().item(1).getTextContent() == "class application.Admin") {
				user = new Admin();
			} else {
				user = new Volunteer();
			}
			users.add(user);
			
			Element userElm = (Element)list.item(i);
			String userID = userElm.getAttribute("id");
			user.setUserID(userID);
			
			user.setfName(getTextFromElement(userElm, "firstName"));
			user.setmInitial(getTextFromElement(userElm, "middleInitial"));
			user.setlName(getTextFromElement(userElm, "lastName"));
			user.setPassword(getTextFromElement(userElm, "password"));
			user.setAddress(getTextFromElement(userElm, "address"));
			user.setCity(getTextFromElement(userElm, "city"));
			user.setState(getTextFromElement(userElm, "firstName"));
			user.setZip(getTextFromElement(userElm, "zipCode"));
			user.setEmail(getTextFromElement(userElm, "email"));
			user.setPhone(getTextFromElement(userElm, "phone"));
		}
		return users;
	}

	private String getTextFromElement(Element userElm, String elementName) {
		Element node = (Element) userElm.getElementsByTagName(elementName).item(0);
		String textContent = node.getTextContent();
		return textContent;
	}
}
