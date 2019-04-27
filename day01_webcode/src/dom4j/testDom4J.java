package dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class testDom4J {
	

	@Test
	public void test1() throws DocumentException{
		SAXReader reader = new SAXReader();//����һ��xml��������
		Document document = reader.read("src/Book.xml");//��xml�ĵ����ص�document
		Element root = document.getRootElement();
		
//		Element bookNode = root.addElement("��");
//		System.out.println(bookNode.getName());
		
		List list = root.elements();
		Element secondBook = (Element)list.get(1);//�õ��ڶ��������
		String name = secondBook.element("����").getText();
		System.out.println(name);
		
	}
	
	@Test
	public void test2() throws DocumentException{
		SAXReader reader = new SAXReader();//����һ��xml��������
		Document document = reader.read("src/Book.xml");//��xml�ĵ����ص�document
		Element root = document.getRootElement();
		
		treeWalk(root);
	}

	private void treeWalk(Element ele) {
		
		System.out.println(ele.getName());//�����ǰ�ڵ������
		
		for (int i = 0; i < ele.nodeCount(); i++) {
			Node node = ele.node(i);//ȡ���±�Ϊi�Ľڵ�
			if(node instanceof Element){//�жϵ�ǰ�ڵ��Ƿ�Ϊ��ǩ
				treeWalk((Element) node);//��nodeǿתΪ��ǩ��Element��
			}
		}
		
	}
}
