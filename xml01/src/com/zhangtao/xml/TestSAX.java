package com.zhangtao.xml ;
import java.io.* ;
import javax.xml.parsers.* ;
public class TestSAX {
	public static void main(String args[]) throws Exception {
		// ����SAX��������
		SAXParserFactory factory = SAXParserFactory.newInstance() ;
		SAXParser parser = factory.newSAXParser() ;
		parser.parse("d:" + File.separator + "sax_demo.xml",new MySAX()) ;
	}
}