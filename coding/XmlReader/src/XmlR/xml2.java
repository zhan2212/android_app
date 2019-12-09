package XmlR;

import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;


public class xml2 {
	
	public static void main(String[] args){
		Document xmlDoc = getDocument("./src/1dayLP_45Days.xml");
		
		xmlDoc.getDocumentElement ().normalize ();
		
		System.out.println("Root:"+
				xmlDoc.getDocumentElement().getNodeName());//some error
		
		NodeList intervalBlocks = xmlDoc.getElementsByTagName("IntervalBlock");
		
		getElement(intervalBlocks);
		


		
		
	}

	private static Document getDocument(String docString) {
		
		try{
			DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
			
			factory.setIgnoringComments(false);
			factory.setIgnoringElementContentWhitespace(true);
			factory.setValidating(false);
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			return builder.parse(new InputSource(docString));
			
			
		}
		
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	private static void getElement(NodeList intervalBlocks){
			
			try{
				for(int i=0; i<intervalBlocks.getLength();i++){
					
					Node node = intervalBlocks.item(i);
					
					Element element = (Element)node;

					
			        if (intervalBlocks.item(i).getNodeType() == Element.COMMENT_NODE) {
			            Comment comment=(Comment) intervalBlocks.item(i);
			            System.out.println(comment.getData());
			            System.out.println(i);
			        }
					
				}
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
			
		}
	
}


