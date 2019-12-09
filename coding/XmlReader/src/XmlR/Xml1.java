package XmlR;

import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;


public class Xml1 {
	
	public static void main(String[] args){
		Document xmlDoc = getDocument("./src/1dayLP_45Days.xml");
		
		xmlDoc.getDocumentElement ().normalize ();
		
		System.out.println("Root:"+
				xmlDoc.getDocumentElement().getNodeName());//some error
		
		NodeList intervalBlocks = xmlDoc.getElementsByTagName("IntervalBlock");
		
		System.out.println("number of blocks:"+
				intervalBlocks.getLength());
		
		//String elementName1 = "cost";
		//getElement(intervalBlocks,elementName1);
		
		//String elementName2 = "duration";
		//getElement(intervalBlocks,elementName2);
		
		//String elementName3 = "start";
		//getElement(intervalBlocks,elementName3);
		
		String elementName4 = "value";
		getElement(intervalBlocks,elementName4);
		

		
		
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
		
		
		
		// TODO Auto-generated method stub
		return null;
	}
	private static void getElement(NodeList intervalBlocks, String elementName){
		
		try{
			for(int i=0; i<intervalBlocks.getLength();i++){
				
				Node node = intervalBlocks.item(i);
				
				Element element = (Element)node;
				
				NodeList networkList = element.getElementsByTagName(elementName);
				
				Element networkElement = (Element)networkList.item(0);
				
				NodeList elementList = networkElement.getChildNodes();
				
				System.out.println(elementName+":"+
						((Node)elementList.item(0)).getNodeValue().trim());
				System.out.println(i);
				
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
}







