package XmlR;

import org.w3c.dom.*;
import org.xml.sax.*;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.*;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class xml4 {
	
	public static void main(String[] args){
		
		
		AssetManager is = getAssets();
		
		
		Document xmlDoc = getDocument("./src/1dayLP_45Days.xml");
		
		xmlDoc.getDocumentElement ().normalize ();
		

		NodeList intervalBlocks = xmlDoc.getElementsByTagName("IntervalBlock");
		

		
		String elementName1 = "cost";
		ArrayList<Integer> costList = getElement(intervalBlocks,elementName1);	
		String elementName2 = "duration";
		ArrayList<Integer> durationList = getElement(intervalBlocks,elementName2);	
		String elementName3 = "start";
		ArrayList<Integer> startList = getElement(intervalBlocks,elementName3);
		String elementName4 = "value";
		ArrayList<Integer> valueList = getElement(intervalBlocks,elementName4);
		
		
		for(int i=0; i<intervalBlocks.getLength();i++){
			System.out.println(i+1+" day");
			System.out.println("cost: "+costList.get(i));
			System.out.println("duration: "+durationList.get(i));
			System.out.println("start: "+startList.get(i));
			System.out.println("value: "+valueList.get(i));
			System.out.println();
		}

		
		
	}

	private static Document getDocument(InputStream is) throws SAXException, IOException,
    ParserConfigurationException{
		
		try{
			DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
			
			factory.setIgnoringComments(false);
			factory.setIgnoringElementContentWhitespace(true);
			factory.setValidating(false);//true
		    factory.setNamespaceAware(true);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			DocumentBuilder dfactory = null;
			dfactory = factory.newDocumentBuilder();
			//dfactory.setEntityResolver(new EntityResolver());

		      // db.setErrorHandler( new MyErrorHandler());

		      return dfactory.parse(is);
			
			
		}
		
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		
		return null;
	}
	private static ArrayList<Integer> getElement(NodeList intervalBlocks, String elementName){
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		try{
			for(int i=0; i<intervalBlocks.getLength();i++){
				
				Node node = intervalBlocks.item(i);
				
				Element element = (Element)node;
				
				NodeList networkList = element.getElementsByTagName(elementName);
				
				Element networkElement = (Element)networkList.item(0);
				
				NodeList elementList = networkElement.getChildNodes();
				
				res.add(Integer.parseInt(((Node)elementList.item(0)).getNodeValue().trim()));
				
				
				//System.out.println(elementName+":"+
				//		((Node)elementList.item(0)).getNodeValue().trim());
				//System.out.println(i);
				
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return res;
	}
	
}