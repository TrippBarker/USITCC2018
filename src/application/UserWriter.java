package application;

import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UserWriter {
	
	public void buildDocument(ArrayList<User> users) throws ParserConfigurationException, TransformerException {
		Document doc = createXMLDoc(users);
		
		DOMSource source = new DOMSource(doc);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xsltindent-amount}", "2");
		
		transformer.transform(source, result);
		String xmlString = writer.toString();
		System.out.println(xmlString);
		
	}

	public Document createXMLDoc(ArrayList<User> users) throws ParserConfigurationException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		
		Element root = doc.createElement("USERS");
		doc.appendChild(root);
		
		for(User user : users) {
			Element userElm = addElement(root, "user", "", doc);
			userElm.setAttribute("id", "2");
			
			addElement(userElm, "name", user.getfName(), doc);
			addElement(userElm, "id", user.getUserID(), doc);
			addElement(userElm, "phone", user.getPhone(), doc);
		}
		
		
		return doc;
	}
	
	public Element addElement(Element parent, String elementName, String textVal, Document doc) {
		Element childElm = doc.createElement(elementName);
		childElm.setTextContent(textVal);
		parent.appendChild(childElm);
		return childElm;
	}
}
