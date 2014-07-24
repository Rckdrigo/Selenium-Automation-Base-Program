package org.globant.reviewBoard;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
//import org.testng.TestNG;
//import org.globant.reviewRequest.TestUnitario;

public class ReviewBoard {
	public static void main(String[] args) {
		try {
			List<XmlSuite> xmlSuites = new ArrayList<XmlSuite>();
			String testXML = "testng.xml";
			
			//forma la lista de suites a probar
			String suite = testXML;
			xmlSuites.addAll((new Parser(suite)).parseToList());
			
			//ejecuta las pruebas
			if(xmlSuites.size() > 0) {
				TestNG test = new TestNG();
				test.setXmlSuites(xmlSuites);
				test.run();
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
