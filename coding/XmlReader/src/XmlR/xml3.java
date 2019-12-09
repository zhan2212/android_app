package XmlR;

import org.w3c.dom.*;
import org.xml.sax.*;

import java.util.ArrayList;

import javax.xml.parsers.*;


public class xml3 {
	
	public static void main(String[] args){
		Document xmlDoc = getDocument("./src/15minLP_15Days.xml");
		
		xmlDoc.getDocumentElement ().normalize ();
		
		System.out.println("Root:"+
				xmlDoc.getDocumentElement().getNodeName());//some error
		
		NodeList intervalBlocks = xmlDoc.getElementsByTagName("IntervalReading");
		
		System.out.println("number of blocks:"+
				intervalBlocks.getLength());
		
		
		String elementName1 = "cost";
		ArrayList<Integer> costList = getElement(intervalBlocks,elementName1);	
		String elementName2 = "duration";
		ArrayList<Integer> durationList = getElement(intervalBlocks,elementName2);	
		String elementName3 = "start";
		ArrayList<Integer> startList = getElement(intervalBlocks,elementName3);
		String elementName4 = "value";
		ArrayList<Integer> valueList = getElement(intervalBlocks,elementName4);
		
		
		for(int i=0; i<96;i++){
			System.out.println((i+1+" hour"));
			//System.out.println("cost: "+costList.get(i));
			//System.out.println("duration: "+durationList.get(i));
			//System.out.println("start: "+startList.get(i));
			System.out.println("value: "+valueList.get(i));
			System.out.println();
		}

		
		
	}

	private static Document getDocument(String docString) {
		
		try{
			DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
			
			factory.setIgnoringComments(false);
			factory.setIgnoringElementContentWhitespace(true);
			factory.setValidating(false);//true
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			return builder.parse(new InputSource(docString));
			
			
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

