package xmlextract;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class XMLReaderTest {
 public static void main(String args[]) {
  Element element = null;
  // ����ʹ�þ���·��
  File f = new File("test.xml");
  // documentBuilderΪ������ֱ��ʵ����(��XML�ļ�ת��ΪDOM�ļ�)
  DocumentBuilder db = null;
  DocumentBuilderFactory dbf = null;
  try {
   // ����documentBuilderFactory����
   dbf = DocumentBuilderFactory.newInstance();
   // ����db������documentBuilderFatory�����÷���documentBuildr����
   db = dbf.newDocumentBuilder();
   // �õ�һ��DOM�����ظ�document����
   Document dt = db.parse(f);
   // �õ�һ��elment��Ԫ��
   element = dt.getDocumentElement();
   // ��ø��ڵ�
   System.out.println("��Ԫ�أ�" + element.getNodeName());
   // ��ø�Ԫ���µ��ӽڵ�
   NodeList childNodes = element.getChildNodes();
   // ������Щ�ӽڵ�
   for (int i = 0; i < childNodes.getLength(); i++) {
    // ���ÿ����Ӧλ��i�Ľ��
    Node node1 = childNodes.item(i);
    if ("Account".equals(node1.getNodeName())) {
     // ����ڵ������Ϊ"Account"�������AccountԪ������type
     System.out.println("\r\n�ҵ�һƪ�˺�. ��������: " + node1.getAttributes().getNamedItem("type").getNodeValue() + ". ");
     // ���<Accounts>�µĽڵ�
     NodeList nodeDetail = node1.getChildNodes();
     // ����<Accounts>�µĽڵ�
     for (int j = 0; j < nodeDetail.getLength(); j++) {
      // ���<Accounts>Ԫ��ÿһ���ڵ�
      Node detail = nodeDetail.item(j);
      if ("code".equals(detail.getNodeName())) // ���code
       System.out.println("����: " + detail.getTextContent());
      else if ("pass".equals(detail.getNodeName())) // ���pass
       System.out.println("����: " + detail.getTextContent());
      else if ("name".equals(detail.getNodeName())) // ���name
       System.out.println("����: " + detail.getTextContent());
      else if ("money".equals(detail.getNodeName())) // ���money
       System.out.println("���: " + detail.getTextContent());
     }
    }
   }
  }
  catch (Exception e) {
   e.printStackTrace();
  }
 }
}
