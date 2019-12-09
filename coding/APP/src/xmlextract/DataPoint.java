package xmlextract;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import paillierScheme.Ciphertext;
import paillierScheme.PaillierKeyPair;
import paillierSchemeException.KeyPairNotMatchException;

public class DataPoint extends test1 
{
	protected int usage;
	public DataPoint(long duration, Calendar date, int usage)
	{
		super(duration, date);
		this.usage = usage;
	}
	
	public static ArrayList<DataPoint> readPoint(String filePath)
	{
		ArrayList<DataPoint> res = new ArrayList<DataPoint>();
		
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document doc = factory.newDocumentBuilder().parse(new File(filePath));

            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xPath = xFactory.newXPath();
            
            XPathExpression durExp = xPath.compile("/feed/entry/content/IntervalBlock/"
            		+ "IntervalReading/timePeriod/duration");
            
            XPathExpression staExp = xPath.compile("/feed/entry/content/IntervalBlock/"
            		+ "IntervalReading/timePeriod/start");
            
            XPathExpression valExp = xPath.compile("/feed/entry/content/IntervalBlock/"
            		+ "IntervalReading/value");
            
            NodeList durList = (NodeList)durExp.evaluate(doc, XPathConstants.NODESET);
            NodeList staList = (NodeList)staExp.evaluate(doc, XPathConstants.NODESET);
            NodeList valList = (NodeList)valExp.evaluate(doc, XPathConstants.NODESET);

            if(durList.getLength() != staList.getLength() || 
            		staList.getLength() != valList.getLength())
            	throw new Exception();
            
            for (int index = 0 ; index < durList.getLength() ; index++) 
            {
                Node durNode = durList.item(index);
                Node staNode = staList.item(index);
                Node valNode = valList.item(index);
                
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(1000 * Long.parseLong(staNode.getTextContent()));
                
                DataPoint point = new DataPoint(Integer.parseInt(durNode.getTextContent()),
                		                        calendar,
                		                        Integer.parseInt(valNode.getTextContent()));
                res.add(point);
            } 
        } 
        catch (Exception e) {
        	e.printStackTrace();
        }
		return res;		
	}
	
	public void PrintData()
	{
		super.PrintData();
		System.out.println("Usage = " + usage + " W*h");
	}
	
	
	public static void main(String args[]){
		String pth = ".//data//homeDay1.xml";
		ArrayList<DataPoint> list = readPoint(pth);
		
		for(DataPoint iter : list)
		{
			iter.PrintData();
			System.out.println();
		}
	}
	
}
	

	
	