package application;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UserWriter {
	
	public void buildDocument(ArrayList<User> users) 
			throws ParserConfigurationException, TransformerException {
		Document doc = createXMLDoc(users);
		outputAsFile(doc, "users.xml");
		
	}
	
	private void outputAsFile(Document doc, String filename) 
			throws TransformerConfigurationException, TransformerException, TransformerFactoryConfigurationError {
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filename));
		getTransformer().transform(source, result);
	}

	private Transformer getTransformer()
			throws TransformerFactoryConfigurationError, TransformerConfigurationException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xsltindent-amount}", "2");
		return transformer;
	}

	public Document createXMLDoc(ArrayList<User> users) 
			throws ParserConfigurationException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		
		Element root = doc.createElement("USERS");
		doc.appendChild(root);

		for(User user : users) {
			Element userElm = addElement(root, "user", "", doc);
			userElm.setAttribute("id", user.getUserID());
			addElement(userElm, "userType", user.getClass().toString(), doc);
			addElement(userElm, "firstName", user.getfName(), doc);
			addElement(userElm, "middleInitial", user.getmInitial(), doc);
			addElement(userElm, "lastName", user.getlName(), doc);
			addElement(userElm, "password", user.getPassword(), doc);
			addElement(userElm, "address", user.getAddress(), doc);
			addElement(userElm, "city", user.getCity(), doc);
			addElement(userElm, "state", user.getState(), doc);
			addElement(userElm, "zipCode", user.getZip(), doc);
			addElement(userElm, "email", user.getEmail(), doc);
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
