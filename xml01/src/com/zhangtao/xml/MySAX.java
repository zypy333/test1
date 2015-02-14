package com.zhangtao.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySAX extends DefaultHandler{

	@Override
	public void startDocument() throws SAXException {
		 System.out.println("<?xml version =\"1.0\" encoding=\"UTF-8\"?>");
	}

	@Override
	public void endDocument() throws SAXException {
		 System.out.println("\nÎÄµµ¶ÁÈ¡½áÊø");
	}

	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		 System.out.print("<");
		 System.out.print(name);
		 if(attributes!=null){
			 for(int x=0;x<attributes.getLength();x++){
				 System.out.print(""+attributes.getQName(x)+"=\""+attributes.getValue(x)+"=\"");
			 }
		 }
		System.out.println(">");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.print("</");
		System.out.print("</");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
	}
	
	 
}
