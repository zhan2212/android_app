package XmlR;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class app {

	
	
	
	
	
	
	
	
	

    
    
	public static void main(String[] args){
		Document xmlDoc = getDocument("./src/main/res/data/1dayLP_45Days.xml");
		
		xmlDoc.getDocumentElement ().normalize ();
		
		System.out.println("Root:"+
				xmlDoc.getDocumentElement().getNodeName());//some error
		
		NodeList intervalBlocks = xmlDoc.getElementsByTagName("IntervalBlock");
		
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
		
		
	    GraphView graph = (GraphView)findViewById(R.id.billchart);
	    LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
	            
	    		for(int i=0;i<intervalBlocks.getLength();i++){
	    			new DataPoint(i, costList.get(i)/100000),		
	    		}
	    });
	    graph.addSeries(series);
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
				
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
