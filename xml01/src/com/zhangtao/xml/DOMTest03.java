package com.zhangtao.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMTest03 {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		Document doc = null;
		doc = builder.newDocument();
		Element addresslist = doc.createElement("addresslist");
		Element linkman = doc.createElement("linkman");
		Element name = doc.createElement("name");
		Element email = doc.createElement("email");
		name.appendChild(doc.createTextNode("ÀîÐË»ª"));
		email.appendChild(doc.createTextNode("dafas@126.com"));
		linkman.appendChild(name);
		linkman.appendChild(email);
		addresslist.appendChild(linkman);
		doc.appendChild(addresslist);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = null;
		try {
			t = tf.newTransformer();
		} catch (TransformerConfigurationException e) {
 
			e.printStackTrace();
		}
		t.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		DOMSource domsource = new DOMSource(doc);
		StreamResult result = new StreamResult("d:" + File.separator
				+ "output.xml");
		try {
			t.transform(domsource, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

}
