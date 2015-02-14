package com.zhangtao.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

;

public class DOMTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Document doc = null;
		try {
			doc = builder.parse("D:" + File.separator + "demo_01.xml");
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NodeList nl = doc.getElementsByTagName("linkman");

		for (int x = 0; x < nl.getLength(); x++) {
			Element e = (Element) nl.item(x);
			// 注意，这里nl是nodeList，他的item是Node，但是Node没getElementsByTagName这个方法
            //name已经属于Element了，应该强制向下转型到Element

			System.out.println("姓名"
					+ e.getElementsByTagName("name").item(0).getFirstChild()
							.getNodeValue());
			System.out.println("邮箱"
					+ e.getElementsByTagName("email").item(0).getFirstChild()
							.getNodeValue());
		}

	}

}
